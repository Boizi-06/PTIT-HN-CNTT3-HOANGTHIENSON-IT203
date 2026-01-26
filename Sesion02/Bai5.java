package Sesion02;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        System.out.println("Hello Java");
        Scanner sc = new Scanner(System.in);
        int defaultTotal = 100;
        int choice;
        do {
            System.out.println("Nhap so sach ban da tra tre");
            int n = sc.nextInt();
            if (n <= 0) {
                choice = 999;
                break;
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.println("Nhap so ngay tra tre cua sach " + (i + 1) + ":");
                    int delay = sc.nextInt();
                    if (delay > 0) {
                        defaultTotal -= delay * 2;
                    } else {
                        defaultTotal += 5;
                    }
                }
            }
            if (defaultTotal > 120) {
                System.out.println("xep loai : Doc gia than thiet");
            } else if (defaultTotal >= 80 && defaultTotal <= 120) {
                System.out.println("xep loai : Doc gia tieu chuan");
            } else {
                System.out.println("xep loai : Doc gia can chu y");
            }
            System.out.println("Nhap 1 de tiep tuc, nhap 999 de thoat");
            choice = sc.nextInt();

        } while (choice != 999);
    }
}
