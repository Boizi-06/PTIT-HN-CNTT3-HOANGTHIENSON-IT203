package Sesion01;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so thu tu sach (stt): ");
        int stt = sc.nextInt();

        // Xác định số kệ (mỗi kệ 25 cuốn)
        int shelfNumber = (stt - 1) / 25 + 1;

        // Xác định vị trí trên kệ (1 → 25)
        int position = (stt - 1) % 25 + 1;

        // Xác định khu vực bằng toán tử điều kiện
        String area = (shelfNumber <= 10) ? "Khu Cận" : "Khu Viễn";

        // In kết quả
        System.out.println("\n===== DIA CHI LUU KHO =====");
        System.out.println("Ke so " + shelfNumber +
                " - Vi tri " + position +
                " - Khu vuc " + area);
        System.out.println("===========================");
    }
}
