package Sesion02;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        System.out.println("Hello Java");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Moi nhap so sach muon");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap so nay tra tre cua sach" + (i + 1) + ":");
            int delay = sc.nextInt();
            total += delay * 5000;
        }
        System.out.println("Tong so tien phai tra la: " + total);
    }
}
