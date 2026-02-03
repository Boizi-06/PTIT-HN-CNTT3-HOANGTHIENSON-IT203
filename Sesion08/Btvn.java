package Sesion08;

import java.util.Scanner;

public class Btvn {

    /* ======================= STUDENT ======================= */
    static class Student {
        private String maSV;
        private String hoTen;
        private int tuoi;
        private String gioiTinh;
        private double diemToan, diemLy, diemHoa;
        private double diemTB;
        private String xepLoai;

        public Student(String maSV, String hoTen, int tuoi, String gioiTinh,
                double diemToan, double diemLy, double diemHoa) {
            this.maSV = maSV;
            this.hoTen = hoTen;
            this.tuoi = tuoi;
            this.gioiTinh = gioiTinh;
            this.diemToan = diemToan;
            this.diemLy = diemLy;
            this.diemHoa = diemHoa;
            tinhDiemTB();
            xepLoai();
        }

        /* ===== Getter & Setter ===== */
        public String getMaSV() {
            return maSV;
        }

        public String getHoTen() {
            return hoTen;
        }

        public int getTuoi() {
            return tuoi;
        }

        public double getDiemTB() {
            return diemTB;
        }

        public String getXepLoai() {
            return xepLoai;
        }

        public void setHoTen(String hoTen) {
            this.hoTen = hoTen;
        }

        public void setTuoi(int tuoi) {
            this.tuoi = tuoi;
        }

        public void setDiem(double toan, double ly, double hoa) {
            this.diemToan = toan;
            this.diemLy = ly;
            this.diemHoa = hoa;
            tinhDiemTB();
            xepLoai();
        }

        /* ===== Logic ===== */
        private void tinhDiemTB() {
            diemTB = (diemToan + diemLy + diemHoa) / 3;
        }

        private void xepLoai() {
            if (diemTB >= 8 && diemToan >= 6.5 && diemLy >= 6.5 && diemHoa >= 6.5)
                xepLoai = "Giỏi";
            else if (diemTB >= 6.5 && diemToan >= 5 && diemLy >= 5 && diemHoa >= 5)
                xepLoai = "Khá";
            else if (diemTB >= 5 && diemToan >= 3.5 && diemLy >= 3.5 && diemHoa >= 3.5)
                xepLoai = "Trung bình";
            else
                xepLoai = "Yếu";
        }

        public void hienThi() {
            System.out.printf("%-10s %-20s %-5d %-10s %-6.2f %-10s\n",
                    maSV, hoTen, tuoi, gioiTinh, diemTB, xepLoai);
        }
    }

    /* ======================= MANAGER ======================= */
    static class StudentManager {
        private Student[] list = new Student[100];
        private int count = 0;

        public boolean isFull() {
            return count == list.length;
        }

        public Student findById(String ma) {
            for (int i = 0; i < count; i++)
                if (list[i].getMaSV().equalsIgnoreCase(ma))
                    return list[i];
            return null;
        }

        public void add(Student s) {
            if (isFull()) {
                System.out.println("❌ Mảng đầy!");
                return;
            }
            if (findById(s.getMaSV()) != null) {
                System.out.println("❌ Trùng mã sinh viên!");
                return;
            }
            list[count++] = s;
            System.out.println("✅ Thêm sinh viên thành công");
        }

        public void display() {
            if (count == 0) {
                System.out.println("⚠️ Danh sách rỗng");
                return;
            }
            System.out.printf("%-10s %-20s %-5s %-10s %-6s %-10s\n",
                    "Mã SV", "Họ tên", "Tuổi", "Giới tính", "ĐTB", "Xếp loại");
            for (int i = 0; i < count; i++)
                list[i].hienThi();
        }

        public void findByName(String key) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (list[i].getHoTen().toLowerCase().contains(key.toLowerCase())) {
                    list[i].hienThi();
                    found = true;
                }
            }
            if (!found)
                System.out.println("❌ Không tìm thấy");
        }

        public void update(String ma, Scanner sc) {
            Student s = findById(ma);
            if (s == null) {
                System.out.println("❌ Không tìm thấy sinh viên");
                return;
            }
            System.out.print("Tên mới: ");
            s.setHoTen(sc.nextLine());

            System.out.print("Tuổi mới: ");
            s.setTuoi(Integer.parseInt(sc.nextLine()));

            System.out.print("Điểm Toán: ");
            double t = Double.parseDouble(sc.nextLine());
            System.out.print("Điểm Lý: ");
            double l = Double.parseDouble(sc.nextLine());
            System.out.print("Điểm Hóa: ");
            double h = Double.parseDouble(sc.nextLine());

            s.setDiem(t, l, h);
            System.out.println("✅ Cập nhật thành công");
        }

        public void delete(String ma) {
            for (int i = 0; i < count; i++) {
                if (list[i].getMaSV().equalsIgnoreCase(ma)) {
                    for (int j = i; j < count - 1; j++)
                        list[j] = list[j + 1];
                    list[--count] = null;
                    System.out.println("✅ Đã xóa");
                    return;
                }
            }
            System.out.println("❌ Không tìm thấy");
        }

        /* Bubble Sort */
        public void sortByScore() {
            for (int i = 0; i < count - 1; i++)
                for (int j = 0; j < count - i - 1; j++)
                    if (list[j].getDiemTB() < list[j + 1].getDiemTB()) {
                        Student tmp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = tmp;
                    }
            System.out.println("✅ Đã sắp xếp theo điểm");
        }

        /* Selection Sort */
        public void sortByName() {
            for (int i = 0; i < count - 1; i++) {
                int min = i;
                for (int j = i + 1; j < count; j++)
                    if (list[j].getHoTen().compareToIgnoreCase(list[min].getHoTen()) < 0)
                        min = j;
                Student tmp = list[i];
                list[i] = list[min];
                list[min] = tmp;
            }
            System.out.println("✅ Đã sắp xếp theo tên");
        }

        public void statistics() {
            int gioi = 0, kha = 0, tb = 0, yeu = 0;
            double sum = 0;
            Student max = list[0], min = list[0];

            for (int i = 0; i < count; i++) {
                sum += list[i].getDiemTB();
                switch (list[i].getXepLoai()) {
                    case "Giỏi":
                        gioi++;
                        break;
                    case "Khá":
                        kha++;
                        break;
                    case "Trung bình":
                        tb++;
                        break;
                    default:
                        yeu++;
                }
                if (list[i].getDiemTB() > max.getDiemTB())
                    max = list[i];
                if (list[i].getDiemTB() < min.getDiemTB())
                    min = list[i];
            }

            System.out.println("📊 THỐNG KÊ");
            System.out.println("Giỏi: " + gioi);
            System.out.println("Khá: " + kha);
            System.out.println("Trung bình: " + tb);
            System.out.println("Yếu: " + yeu);
            System.out.printf("Điểm TB chung: %.2f\n", sum / count);
            System.out.println("Cao nhất: " + max.getHoTen());
            System.out.println("Thấp nhất: " + min.getHoTen());
        }
    }

    /* ======================= MAIN ======================= */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Cập nhật");
            System.out.println("5. Xóa");
            System.out.println("6. Tính điểm & xếp loại");
            System.out.println("7. Sắp xếp");
            System.out.println("8. Thống kê");
            System.out.println("9. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Mã SV: ");
                    String ma = sc.nextLine();
                    System.out.print("Họ tên: ");
                    String ten = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int tuoi = Integer.parseInt(sc.nextLine());
                    System.out.print("Giới tính: ");
                    String gt = sc.nextLine();
                    System.out.print("Toán: ");
                    double t = Double.parseDouble(sc.nextLine());
                    System.out.print("Lý: ");
                    double l = Double.parseDouble(sc.nextLine());
                    System.out.print("Hóa: ");
                    double h = Double.parseDouble(sc.nextLine());

                    manager.add(new Student(ma, ten, tuoi, gt, t, l, h));
                    break;
                case 2:
                    manager.display();
                    break;
                case 3:
                    System.out.print("Nhập tên/mã: ");
                    manager.findByName(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhập mã SV: ");
                    manager.update(sc.nextLine(), sc);
                    break;
                case 5:
                    System.out.print("Nhập mã SV: ");
                    manager.delete(sc.nextLine());
                    break;
                case 7:
                    System.out.println("1. Theo điểm | 2. Theo tên");
                    if (Integer.parseInt(sc.nextLine()) == 1)
                        manager.sortByScore();
                    else
                        manager.sortByName();
                    break;
                case 8:
                    manager.statistics();
                    break;
            }
        } while (choice != 9);
    }
}
