import java.util.Scanner;

public class BTTH {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        int[] idBooks = new int[100];
        int[] quantities = new int[100];
        String[] titles = new String[100];
        int a = 0;
        do {
            // ===== MENU =====
            System.out.println("\n===== MENU QUAN LY SACH =====");
            System.out.println("1. Xem danh sach sach");
            System.out.println("2. Them sach moi");
            System.out.println("3. Cap nhat so luong");
            System.out.println("4. Xoa sach");
            System.out.println("5. Tim kiem sach");
            System.out.println("6. Sap xep theo so luong (giam dan)");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            choice = sc.nextInt();
            sc.nextLine(); // xóa bộ đệm

            switch (choice) {
                case 1:
                    // Xem danh sach
                    xemDanhSach(idBooks, titles, quantities, a);
                    break;

                case 2:
                    System.out.println("Them id sach moi:");
                    int newId = sc.nextInt();
                    sc.nextLine(); // xóa bộ đệm
                    System.out.println("Them ten sach moi:");
                    String newTitle = sc.nextLine();
                    System.out.println("Them so luong sach moi:");
                    int newQuantity = sc.nextInt();
                    if (a == 0) {
                        idBooks[a] = newId;
                        titles[a] = newTitle;
                        quantities[a] = newQuantity;
                        a++;
                        System.out.println("Da them sach moi thanh cong!");
                    } else {
                        for (int i = 0; i < a; i++) {
                            if (idBooks[i] == newId) {
                                System.out.println("Sach da ton tai!");
                                break;
                            } else if (i == a - 1) {
                                idBooks[a] = newId;
                                titles[a] = newTitle;
                                quantities[a] = newQuantity;
                                a++;
                                System.out.println("Da them sach moi thanh cong!");
                                break;
                            }
                        }
                    }
                    break;

                case 3:
                    // Cap nhat so luong
                    editQuantity(a, idBooks, quantities, sc, titles);
                    System.out.println("cap nhat so luong sach thanh cong");
                    xemDanhSach(idBooks, titles, quantities, a);
                    break;

                case 4:
                    // Xoa sach
                    a = deleteThisBook(a, idBooks, quantities, titles, sc);
                    break;

                case 5:
                    // Tim kiem
                    findBook(a, idBooks, quantities, titles, sc);
                    break;

                case 6:
                    // Sap xep theo so luong giam dan
                    sortBook(a, idBooks, quantities, titles);
                    xemDanhSach(idBooks, titles, quantities, a);
                    break;

                case 0:
                    System.out.println("Da thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void xemDanhSach(int[] idBooks, String[] titles, int[] quantities, int a) {
        System.out.println("\nDanh sach sach:");
        System.out.printf("%-10s %-30s %-10s\n", "ID Sach", "Ten Sach", "So Luong");
        for (int i = 0; i < a; i++) {
            System.out.printf("%-10d %-30s %-10d\n", idBooks[i], titles[i], quantities[i]);
        }
    }

    public static int[] editQuantity(int a, int[] idBooks, int[] quantities, Scanner sc, String[] t) {
        System.out.println("nhap id cua sach ban muon thay doi so luong");
        int key = sc.nextInt();
        int index = 0;
        sc.nextLine();
        for (int i = 0; i < a; i++) {
            if (key == idBooks[i]) {
                index = i;
                break;
            }
            if (i == a - 1) {
                System.out.println("id sach ban tim khong ton tai");
            }
        }
        System.out.println("moi ban nhap so luong cua sach co ten :" + t[index]);
        int newValue = sc.nextInt();
        quantities[index] = newValue;
        return quantities;
    }

    public static int deleteThisBook(int a, int[] b, int[] sl, String[] t, Scanner sc) {
        System.out.println("moi ban nhap id cua sach muon xoa");
        int key = sc.nextInt();
        int index = -1;
        sc.nextLine();
        for (int i = 0; i < a; i++) {
            if (b[i] == key) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("id sach ban muon xoa khong ton tai");
            return a;
        }

        String name = t[index];
        for (int i = index; i < a - 1; i++) {
            b[i] = b[i + 1];
            t[i] = t[i + 1];
            sl[i] = sl[i + 1];
        }

        b[a - 1] = 0;
        t[a - 1] = null;
        sl[a - 1] = 0;
        a--;
        System.out.println("xoa thanh cong sach co ten la : " + name);

        return a;
    }

    public static int findBook(int a, int[] b, int[] sl, String[] t, Scanner sc) {
        System.out.println("moi ban nhap id sach ma ban muon tim kiem \n");
        int key = sc.nextInt();
        sc.nextLine();
        int index = -1;
        for (int i = 0; i < a; i++) {
            if (key == b[i]) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("id sach ban muon xoa khong ton tai");
            return 1;
        }
        System.out.printf("%-10s %-30s %-10s\n", "ID Sach", "Ten Sach", "So Luong");
        System.out.printf("%-10d %-30s %-10d\n", b[index], t[index], sl[index]);
        return 1;
    }

    public static void sortBook(int a, int[] b, int[] sl, String[] t) {

        for (int i = 0; i < a - 1; i++) {
            for (int j = 0; j < a - i - 1; j++) {

                if (sl[j] < sl[j + 1]) { // giảm dần

                    // đổi số lượng
                    int tempSl = sl[j];
                    sl[j] = sl[j + 1];
                    sl[j + 1] = tempSl;

                    // đổi id
                    int tempId = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = tempId;

                    // đổi tên
                    String tempTitle = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = tempTitle;
                }
            }
        }

        System.out.println("Da sap xep theo so luong giam dan!");
    }

}
