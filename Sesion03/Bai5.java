import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach muon quan ly: ");
        int n = sc.nextInt();
        System.out.println("So luong sach muon quan ly: " + n);
        int[] arrBook = arrBook(n, sc);
        printBook(arrBook, n);
        System.out.println("nhap id sach ban muon xoa ");
        int key = sc.nextInt();
        int[] newArr = deleteThisBook(n, arrBook, key);

        printBook(newArr, newArr.length);

    }

    public static int[] arrBook(int n, Scanner sc) {
        int arrBook[] = new int[n];
        System.out.println("Nhap ID cac sach:");
        for (int index = 0; index < n; index++) {
            arrBook[index] = sc.nextInt();
        }
        return arrBook;
    }

    public static void printBook(int arrBook[], int n) {
        System.out.println("Danh sach ID sach:\n");
        for (int index = 0; index < n; index++) {
            if (index == n - 1) {
                System.out.print(arrBook[index] + "\n");
                break;
            }
            System.out.print(arrBook[index] + " , ");
        }
    }

    public static int[] deleteThisBook(int n, int arrBook[], int key) {
        int count = 0;

        // Đếm xem key xuất hiện bao nhiêu lần
        for (int i = 0; i < n; i++) {
            if (arrBook[i] == key) {
                count++;
            }
        }

        // Nếu không tìm thấy
        if (count == 0) {
            System.out.println("Khong tim thay sach co ID = " + key);
            return arrBook;
        }

        int[] newArr = new int[n - count];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arrBook[i] != key) {
                newArr[index++] = arrBook[i];
            }
        }

        return newArr;
    }

}
