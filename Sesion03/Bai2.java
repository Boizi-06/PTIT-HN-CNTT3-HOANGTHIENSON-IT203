import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        System.out.println("Hello Java");
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("Nhap so luong sach muon quan ly:");
        n = sc.nextInt();

        int[] books = arrBook(n, sc);

        printBook(books);
    }

    // ham nhap id sach
    public static int[] arrBook(int n, Scanner sc) {
        int arrBook[] = new int[n];
        System.out.println("Nhap ID cac sach:");
        for (int index = 0; index < n; index++) {
            arrBook[index] = sc.nextInt();
        }
        return arrBook;
    }

    // ham in sach
    public static void printBook(int arrBook[]) {
        System.out.println("Danh sach ID sach:");
        for (int index = 0; index < arrBook.length; index++) {
            System.out.print(arrBook[index] + " , ");
        }
    }
}
