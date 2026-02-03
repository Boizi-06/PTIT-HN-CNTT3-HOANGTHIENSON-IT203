package Sesion08;

import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double score;

    public Student() {
    }

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank() {
        if (score >= 8.0) {
            return "Gioi";
        } else if (score >= 6.5) {
            return "Kha";
        } else {
            return "Trung Binh";
        }
    }

    public String toString() {
        return "MSV: " + id +
                " | Ten: " + name +
                " | Diem: " + score +
                " | Hoc luc: " + getRank();
    }
}

public class Thuchanh {
    static Scanner sc = new Scanner(System.in);
    static Student[] listStudent = new Student[100];
    static int count = 0;

    public static void printMenu() {
        System.out.println("===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
        System.out.println("1. Nhập danh sách sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Tìm kiếm sinh viên theo Học lực");
        System.out.println("4. Sắp xếp theo học lực giảm dần");
        System.out.println("5. Thoát");
        System.out.println("==================================");
        System.out.print("Chọn chức năng: ");
    }

    public static void inputStudents() {
        System.out.print("Nhap so luong sinh vien can quan ly: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Sinh vien " + (i + 1));

            String id;
            while (true) {
                System.out.print("Nhap ma SV (SVxxx): ");
                id = sc.nextLine();
                if (id.startsWith("SV") && id.length() == 5) {
                    break;
                }
                System.out.println("Ma sinh vien nhap vao ko hjop le");
            }

            System.out.print("Nhap ten: ");
            String name = sc.nextLine();

            System.out.print("Nhap diem: ");
            double score = sc.nextDouble();
            sc.nextLine();

            listStudent[count++] = new Student(id, name, score);
        }
    }

    public static void showStudents() {
        if (count == 0) {
            System.out.println("Danh sach sinh vien trong");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(listStudent[i]);
        }
    }

    public static void searchByRank() {
        System.out.print("Nhap luc hoc can tim: ");
        String rank = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (listStudent[i].getRank().equalsIgnoreCase(rank)) {
                System.out.println(listStudent[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien");
        }
    }

    public static void sortByScoreDesc() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (listStudent[i].getScore() < listStudent[j].getScore()) {
                    Student temp = listStudent[i];
                    listStudent[i] = listStudent[j];
                    listStudent[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo học lực giảm dần!");
    }

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    inputStudents();
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    searchByRank();
                    break;
                case 4:
                    sortByScoreDesc();
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 5);
    }
}
