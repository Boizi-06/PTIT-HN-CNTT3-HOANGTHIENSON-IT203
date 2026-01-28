package Sesion04;

import java.util.Scanner;

public class Bai1 {
    public static String chuanHoaKhoangTrang(String s) {
        return s.trim().replaceAll("\\s+", " ");
    }

    public static String vietHoaChuDau(String s) {
        s = chuanHoaKhoangTrang(s).toLowerCase();
        String[] words = s.split(" ");
        String result = "";
        for (String word : words) {
            result += word.substring(0, 1).toUpperCase()
                    + word.substring(1) + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ten sach: ");
        String tenSach = sc.nextLine();

        System.out.print("nhap ten tac gia: ");
        String tacGia = sc.nextLine();

        System.out.print("nhap the loai: ");
        String theLoai = sc.nextLine();
        tenSach = chuanHoaKhoangTrang(tenSach).toUpperCase();
        tacGia = vietHoaChuDau(tacGia);
        theLoai = chuanHoaKhoangTrang(theLoai);
        System.out.println(tenSach + " - Tac gia: " + tacGia);

        sc.close();
    }
}