package Sesion01;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu
        System.out.print("Nhap ma sach: ");
        String bookID = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        String bookName = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int publishYear = sc.nextInt();

        System.out.print("Nhap gia tien: ");
        double price = sc.nextDouble();

        System.out.print("Sach con trong kho? (true/false): ");
        boolean isAvailable = sc.nextBoolean();

        // Tính tuổi thọ sách
        int age = 2026 - publishYear;

        // Xử lý dữ liệu
        String bookNameUpper = bookName.toUpperCase();
        String status = isAvailable ? "Còn sách" : "Đã mượn";

        // In phiếu thông tin
        System.out.println("\n===== PHIEU THONG TIN SACH =====");
        System.out.println("Ma sach: " + bookID);
        System.out.println("Ten sach: " + bookNameUpper);
        System.out.println("Nam xuat ban: " + publishYear);
        System.out.printf("Gia tien: %.2f\n", price);
        System.out.println("Tuoi tho sach: " + age);
        System.out.println("Tinh trang: " + status);
        System.out.println("===============================");
    }
}
