package Sesion01;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu
        System.out.print("Nhap gia sach (USD): ");
        double priceUSD = sc.nextDouble();

        System.out.print("Nhap ty gia (VND/USD): ");
        float rate = sc.nextFloat();

        // Tính tiền VNĐ (double)
        double vndDouble = priceUSD * rate;

        // Ép kiểu sang long (làm tròn xuống)
        long vndLong = (long) vndDouble;

        // In kết quả
        System.out.println("\n===== KET QUA DOI TIEN =====");
        System.out.println("Gia USD: " + priceUSD);
        System.out.println("Ty gia: " + rate);
        System.out.println("Tien VNĐ (double): " + vndDouble);
        System.out.println("Tien VNĐ (lam tron): " + vndLong + " VND");
        System.out.println("===========================");
    }
}
