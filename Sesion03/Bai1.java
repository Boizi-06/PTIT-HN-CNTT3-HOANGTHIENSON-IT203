import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        System.out.println("Hello Java");
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap so luong sach muon quan ly:");
        n = sc.nextInt();
        int arrBook[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap id cua sach thu " + (i + 1) + ":");
            arrBook[i] = sc.nextInt();
        }
        System.out.println("Danh sach id sach vua nhap:");
        for (int i = 0; i < n; i++) {
            System.out.print(+arrBook[i] + "  ,");
        }
    }
}
