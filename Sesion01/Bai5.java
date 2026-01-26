
package Sesion01;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma sach 4 chu so: ");
        int number = sc.nextInt();

        // Tách các chữ số (chỉ dùng toán tử số học)
        int thousands = number / 1000;
        int hundreds = (number / 100) % 10;
        int dozens = (number / 10) % 10;
        int units = number % 10;

        // Tính tổng 3 chữ số đầu
        int sumOfFirstThreeNumber = thousands + hundreds + dozens;

        // Lấy số kiểm tra
        int checkDigit = sumOfFirstThreeNumber % 10;

        // Toán tử logic để kiểm tra hợp lệ
        boolean isValid = (checkDigit == units);

        // In kết quả
        System.out.println("\n===== KET QUA KIEM TRA =====");
        System.out.println("Thousands: " + thousands);
        System.out.println("Hundreds : " + hundreds);
        System.out.println("Dozens   : " + dozens);
        System.out.println("Units    : " + units);
        System.out.println("Check digit tinh duoc: " + checkDigit);
        System.out.println("Ma hop le: " + isValid);
        System.out.println("============================");
    }
}
