package Sesion02;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {

        boolean isCheck = true; //

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Moi ban nhap ky tu");
            char c = sc.next().charAt(0);

            switch (c) {
                case 'A':
                    System.out.println("Tầng 1: Sách Văn học");
                    break;
                case 'B':
                    System.out.println("Tầng 2: Sách Khoa học");
                    break;
                case 'C':
                    System.out.println("Tầng 3: Sách Ngoại ngữ");
                    break;
                case 'D':
                    System.out.println("Tầng 4: Sách Tin học");
                    break;
                case 'E':
                    System.out.println("Thoat Chuong trinh");
                    isCheck = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }

        } while (isCheck);

        sc.close();
    }
}
