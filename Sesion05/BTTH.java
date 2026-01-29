package Sesion05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BTTH {

    public static void main(String[] args) {

        String[] mssvList = new String[100];
        int[] size = { 0 };

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Chon chuc nang: ");
            choice = readInt(sc);

            switch (choice) {
                case 1:
                    displayList(size, mssvList);
                    break;
                case 2:
                    addMSSV(size, mssvList, sc);
                    break;
                case 3:
                    updateMSSV(size, mssvList, sc);
                    break;
                case 4:
                    deleteMSSV(size, mssvList, sc);
                    break;
                case 5:
                    searchMSSV(size, mssvList, sc);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    static void showMenu() {
        System.out.println("\n========= QUAN LY MSSV =========");
        System.out.println("1. Hien thi sanh sach MSSV");
        System.out.println("2. Thêm MSSV moi");
        System.out.println("3. Update MSSV");
        System.out.println("4. Delete MSSV");
        System.out.println("5. Tim kiem MSSV");
        System.out.println("0. EXIT");
        System.out.println("================================");
    }

    static void displayList(int[] size, String[] mssvList) {
        if (size[0] == 0) {
            System.out.println("Chua co sinh vien nao");
            return;
        }

        for (int i = 0; i < size[0]; i++) {
            System.out.println((i + 1) + ". " + mssvList[i]);
        }
    }

    static void addMSSV(int[] size, String[] mssvList, Scanner sc) {
        if (size[0] >= 100) {
            System.out.println("Het bo Nho");
            return;
        }

        String mssv = inputValidMSSV(sc);
        mssvList[size[0]] = mssv;
        size[0]++;

        System.out.println("Them sinh vien thanh cong");
    }

    static void updateMSSV(int[] size, String[] mssvList, Scanner sc) {
        if (size[0] == 0) {
            System.out.println(" Chua co sinh vien nao");
            return;
        }

        System.out.print("nhap index cua sinh vien can sua: ");
        int index = readInt(sc);

        if (index < 0 || index >= size[0]) {
            System.out.println(" Chi so index cua sinh vien nhap vao khong hop le");
            return;
        }

        String newMssv = inputValidMSSV(sc);
        mssvList[index] = newMssv;

        System.out.println(" Cap nhat MSSV thanh cong");
    }

    static void deleteMSSV(int[] size, String[] mssvList, Scanner sc) {
        if (size[0] == 0) {
            System.out.println("CHua co sinh vien nao");
            return;
        }

        System.out.print("Nhap MSSV can xoa: ");
        String target = sc.nextLine();

        int pos = -1;
        for (int i = 0; i < size[0]; i++) {
            if (mssvList[i].equalsIgnoreCase(target)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println(" Khong tim thay");
            return;
        }

        for (int i = pos; i < size[0] - 1; i++) {
            mssvList[i] = mssvList[i + 1];
        }

        mssvList[size[0] - 1] = null;
        size[0]--;

        System.out.println("Xoa thanh cong");
    }

    static void searchMSSV(int[] size, String[] mssvList, Scanner sc) {
        if (size[0] == 0) {
            System.out.println(" Chua co sinh vien nao");
            return;
        }

        System.out.print("Nhap MSSV : ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < size[0]; i++) {
            if (mssvList[i].toLowerCase().contains(keyword)) {
                System.out.println(mssvList[i]);
                found = true;
            }
        }

        if (!found)
            System.out.println(" KHong thay sinh vien ");
    }

    static String inputValidMSSV(Scanner sc) {
        while (true) {
            System.out.print("Nhap MSSV (Bxxxxxxx): ");
            String mssv = sc.nextLine();

            if (Pattern.matches("^B\\d{7}$", mssv))
                return mssv;

            System.out.println("Sai dinh dang!");
        }
    }

    static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Nhap so hop le: ");
            }
        }
    }
}
