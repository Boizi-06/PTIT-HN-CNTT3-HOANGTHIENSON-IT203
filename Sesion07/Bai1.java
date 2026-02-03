package Sesion07;

public class Bai1 {

    // Lớp Student (đặt trong cùng file)
    static class Student {
        // Biến instance (mỗi sinh viên có riêng)
        private String id;
        private String name;

        // Biến static (dùng chung cho tất cả sinh viên)
        private static int totalStudent = 0;

        // Constructor
        public Student(String id, String name) {
            this.id = id;
            this.name = name;
            totalStudent++;
        }

        // Hiển thị thông tin sinh viên
        public void display() {
            System.out.println("ID: " + id + " | Name: " + name);
        }

        // Hiển thị tổng số sinh viên
        public static void showTotalStudent() {
            System.out.println("Total students: " + totalStudent);
        }
    }

    // Hàm main
    public static void main(String[] args) {
        Student s1 = new Student("SV01", "An");
        Student s2 = new Student("SV02", "Bình");
        Student s3 = new Student("SV03", "Cường");

        s1.display();
        s2.display();
        s3.display();

        Student.showTotalStudent();
    }
}
