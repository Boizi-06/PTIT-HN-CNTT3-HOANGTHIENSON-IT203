package Sesion06;

public class Bai4 {

    // Class Employee
    static class Employee {
        String maNV;
        String tenNV;
        double luong;

        // Constructor KHÔNG tham số
        public Employee() {
            maNV = "Chưa có";
            tenNV = "Chưa có";
            luong = 0;
        }

        // Constructor có mã và tên
        public Employee(String maNV, String tenNV) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luong = 0;
        }

        // Constructor đầy đủ mã, tên, lương
        public Employee(String maNV, String tenNV, double luong) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luong = luong;
        }

        // Phương thức hiển thị thông tin
        public void hienThiThongTin() {
            System.out.println("Mã NV: " + maNV);
            System.out.println("Tên NV: " + tenNV);
            System.out.println("Lương: " + luong);
            System.out.println("--------------------");
        }
    }

    // Hàm main
    public static void main(String[] args) {

        // Tạo đối tượng bằng constructor không tham số
        Employee nv1 = new Employee();

        // Tạo đối tượng bằng constructor có mã và tên
        Employee nv2 = new Employee("NV01", "Nguyễn Văn A");

        // Tạo đối tượng bằng constructor đầy đủ
        Employee nv3 = new Employee("NV02", "Trần Thị B", 15000000);

        nv1.hienThiThongTin();
        nv2.hienThiThongTin();
        nv3.hienThiThongTin();
    }
}
