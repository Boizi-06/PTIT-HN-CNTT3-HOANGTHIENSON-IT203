package Sesion02;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Moi ban nhap so tuoi");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        System.out.println("So sach ban da muon");
        int book = sc.nextInt();
        if (age >= 18 && book <= 3) {
            System.out.println("Ban du dieu kien muon sach");
        } else {
            System.out.println("Ban khong du dieu kien muon sach");

        }
    }
}
