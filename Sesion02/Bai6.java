package Sesion02;

import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {
        System.out.println("Hello Java");
        int temp, a;
        int max = 0, min = 0;
        float avg = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            System.out.println("Nhap so lan muon sach cua thu " + (i + 2) + ":");
            a = sc.nextInt();
            if (a <= 0) {
                continue;
            } else {
                avg += a;
                if (i == 0) {
                    min = a;
                }
                if (a > max) {
                    max = a;
                } else if (a < min) {
                    min = a;
                }
            }
        }
        avg /= 7;
        System.out.println("So lan muon sach lon nhat: " + max);
        System.out.println("So lan muon sach nho nhat: " + min);
        System.out.printf("So lan muon sach trung binh: %.2f", avg);
    }
}
