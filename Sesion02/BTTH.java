package Sesion02;

import java.util.Scanner;

public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n====== MENU THU THU ======");
            System.out.println("1. Tinh tien phat tra sach");
            System.out.println("2. Dang ky the VIP");
            System.out.println("3. Thong ke sach nhap kho");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    tinhTienPhat(sc);
                    break;
                case 2:
                    dangKyVIP(sc);
                    break;
                case 3:
                    thongKeNhapKho(sc);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // ===== Chuc nang 1 =====
    static void tinhTienPhat(Scanner sc) {
        System.out.print("Nhap so luong sach: ");
        int n = sc.nextInt();

        int tongTien = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhap so ngay tre cua sach " + i + ": ");
            int days = sc.nextInt();

            if (days <= 0)
                continue;

            if (days <= 5) {
                tongTien += days * 2000;
            } else {
                tongTien += 5 * 2000 + (days - 5) * 5000;
            }
        }

        System.out.println("Tong tien phat: " + tongTien + " VND");
    }

    // ===== Chuc nang 2 =====
    static void dangKyVIP(Scanner sc) {
        System.out.print("Nhap tuoi: ");
        int age = sc.nextInt();

        System.out.print("Nhap so sach da muon trong thang: ");
        int books = sc.nextInt();

        System.out.print("Co the sinh vien uu tien? (1 = co, 0 = khong): ");
        int student = sc.nextInt();

        boolean isVIP = (age >= 18 && books >= 10) || (student == 1);

        String result = isVIP ? "Du tieu chuan nang cap VIP" : "Chua du tieu chuan";
        System.out.println(result);
    }

    // ===== Chuc nang 3 =====
    static void thongKeNhapKho(Scanner sc) {
        int count = 0;
        int code;

        do {
            System.out.print("Nhap ma sach (0 = dung): ");
            code = sc.nextInt();

            if (code < 0) {
                System.out.println("Ma am, nhap lai!");
                continue;
            }

            if (code == 0) {
                break;
            }

            count++;

        } while (true);

        System.out.println("Tong so sach hop le da nhap: " + count);
    }
}
