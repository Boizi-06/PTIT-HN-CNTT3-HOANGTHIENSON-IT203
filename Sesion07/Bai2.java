package Sesion07;

public class Bai2 {

    // Lớp Student
    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        // ===== 1. BIẾN NGUYÊN THỦY =====
        int a = 10;
        int b = a; // sao chép GIÁ TRỊ

        b = 20;

        System.out.println("BIẾN NGUYÊN THỦY:");
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 20

        // ===== 2. BIẾN THAM CHIẾU =====
        Student s1 = new Student("An");
        Student s2 = s1; // sao chép ĐỊA CHỈ

        s2.name = "Bình";

        System.out.println("\nBIẾN THAM CHIẾU:");
        System.out.println("s1.name = " + s1.name); // Bình
        System.out.println("s2.name = " + s2.name); // Bình
    }
}
