package Sesion04;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nhap mo ta sach: ");
        String moTa = sc.nextLine();

        if (moTa.contains("Kệ:")) {
            int start = moTa.indexOf("Kệ:") + "Kệ:".length();

            int end = moTa.indexOf(",", start);
            if (end == -1) {
                end = moTa.length();
            }

            String maKe = moTa.substring(start, end).trim();

            System.out.println("ma vi tri ke sach: " + maKe);

            String moTaMoi = moTa.replace("Kệ:", "Vị trí lưu trữ:");
            System.out.println("mo ta sau khi thay the:");
            System.out.println(moTaMoi);
        } else {
            System.out.println("khong tim thay thong tin ke sach trong mo ta");
        }

        sc.close();
    }
}
