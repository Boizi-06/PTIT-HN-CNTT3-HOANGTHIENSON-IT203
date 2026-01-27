import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        System.out.println("Hello Java");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach muon quan ly: ");
        int n = sc.nextInt();
        sc.nextLine();

        int[] arrBook = createBook(n, sc);
        printBook(arrBook);
        sortBook(arrBook);
        System.out.println("\nDanh sach ID sach sau khi sap xep:");
        printBook(arrBook);
    }

    public static int[] createBook(int n, Scanner sc) {
        int[] books = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap id sach:" + (i + 1));
            books[i] = sc.nextInt();
        }
        return books;
    }

    public static void printBook(int arrBook[]) {
        System.out.println("Danh sach ID sach:");
        for (int index = 0; index < arrBook.length; index++) {
            System.out.print(arrBook[index] + " , ");
        }
    }

    public static void sortBook(int arrBook[]) {
        for (int i = 0; i < arrBook.length - 1; i++) {
            for (int j = i + 1; j < arrBook.length; j++) {
                if (arrBook[i] > arrBook[j]) {
                    // swap
                    int temp = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = temp;
                }
            }
        }
    }
}