import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sach muon quan ly: ");
        int n = sc.nextInt();
        sc.nextLine(); // bỏ ký tự xuống dòng

        String[] arrBook = createBook(n, sc);
        int[] quantityBook = createQuantityBook(n, sc, arrBook);

        int min = quantityBook[0];
        int max = quantityBook[0];

        // Tìm min và max
        for (int i = 1; i < n; i++) {
            if (quantityBook[i] < min) {
                min = quantityBook[i];
            }
            if (quantityBook[i] > max) {
                max = quantityBook[i];
            }
        }

        // In sách ít nhất
        System.out.println("\nSach co so luong it nhat:");
        for (int i = 0; i < n; i++) {
            if (quantityBook[i] == min) {
                System.out.println(arrBook[i] + " - " + min);
            }
        }

        // In sách nhiều nhất
        System.out.println("\nSach co so luong nhieu nhat:");
        for (int i = 0; i < n; i++) {
            if (quantityBook[i] == max) {
                System.out.println(arrBook[i] + " - " + max);
            }
        }
    }

    public static String[] createBook(int n, Scanner sc) {
        String[] books = new String[n];
        System.out.println("Nhap ten cac sach:");
        for (int i = 0; i < n; i++) {
            books[i] = sc.nextLine();
        }
        return books;
    }

    public static int[] createQuantityBook(int n, Scanner sc, String[] arrBook) {
        int[] quantityBook = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap so luong cua sach " + arrBook[i] + ": ");
            quantityBook[i] = sc.nextInt();
        }
        return quantityBook;
    }
}
