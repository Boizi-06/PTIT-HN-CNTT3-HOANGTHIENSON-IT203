package Sesion02;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        int id;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhap ID cua sach (ID >= 0):");
            id = sc.nextInt();
            if (id >= 0) {
                System.out.println("ID hop le");
            } else {
                System.out.println("ID khong hop le, vui long nhap lai");
            }
        } while (id <= 0);
    }
}
