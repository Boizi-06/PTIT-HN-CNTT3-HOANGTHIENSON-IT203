package Sesion01;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu
        System.out.print("Nhap so ngay tre (n): ");
        int n = sc.nextInt();

        System.out.print("Nhap so luong sach muon (m): ");
        int m = sc.nextInt();

        // Tính tiền phạt cơ bản
        double total = n * m * 5000;

        // Kiểm tra điều kiện đặc biệt (toán tử logic)
        if (n > 7 && m >= 3) {
            total = total * 1.2; // tăng 20%
        }

        // Kiểm tra yêu cầu khóa thẻ (toán tử so sánh)
        boolean lockCard = total > 50000;

        // Xuất kết quả
        System.out.println("\n===== KET QUA TINH TIEN PHAT =====");
        System.out.println("So ngay tre: " + n);
        System.out.println("So sach muon: " + m);
        System.out.printf("Tong tien phat: %.0f VND\n", total);
        System.out.println("Yeu cau khoa the: " + lockCard);
        System.out.println("================================");
    }
}
