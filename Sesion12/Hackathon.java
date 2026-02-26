package Sesion12;

import java.util.Scanner;

public class Hackathon {

    // ham cua cau 1

    // chu cai xhien nhieu nhat
    public static void maxChar(String str) {
        str = str.toLowerCase();
        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                count[ch]++;
            }
        }

        int max = 0;
        char result = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                if (count[ch] > max) {
                    max = count[ch];
                    result = ch;
                }
            }
        }

        if (max > 0) {
            System.out.println(result + " : " + max);
        }
    }

    // ham su li cau 2

    // ham don so dương ve trai
    public static void donMang(int[] arr) {
        int insertPos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                int temp = arr[i];
                for (int j = i; j > insertPos; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[insertPos] = temp;
                insertPos++;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // ham xoa phan tư
    public static void delete(int[] arr, int x) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            if (arr[i] == x) {
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                size--;
                i--;
            }
        }

        if (size == 0) {
            System.out.println("Mang rong");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ham su li cau 3

    public static void unionArray(int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int size = 0;

        for (int i = 0; i < A.length; i++) {
            boolean exists = false;
            for (int j = 0; j < size; j++) {
                if (result[j] == A[i]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                result[size++] = A[i];
            }
        }

        for (int i = 0; i < B.length; i++) {
            boolean exists = false;
            for (int j = 0; j < size; j++) {
                if (result[j] == B[i]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                result[size++] = B[i];
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    // chuong trinh cua main

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // phan 1
        System.out.println("== CAU 1 ==");
        System.out.print("Nhap chuoi: ");
        String str = sc.nextLine();
        System.out.println("Dao nguoc tung tu:");
        String result = "";
        String word = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ' ') {
                word = ch + word;
            } else {
                result += word + " ";
                word = "";
            }
        }

        result += word;
        System.out.println(result);
        System.out.println("Ky tu xuat hien nhieu nhat:");
        maxChar(str);

        // phan 2
        System.out.println("\n===== CAU 2 =======");
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("so luong phan tu trong mang phai lon hon 0");
            return;
        }
        int[] arr = new int[n];
        System.out.println("Nhap mang:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Mang sau khi don so :");
        donMang(arr);

        System.out.print("Nhap n: ");
        int n2 = sc.nextInt();
        if (n2 <= 0) {
            System.out.println("so luong phan tu trong mang phai lon hon 0");
            return;
        }
        int[] arr2 = new int[n2];
        System.out.println("Nhap mang:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.print("Nhap x can xoa: ");
        int x = sc.nextInt();

        int size = arr2.length;
        int count = 0;
        if (size == 0) {
            System.out.println("Mang rong");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (arr2[i] == x) {
                for (int j = i; j < size - 1; j++) {
                    arr2[j] = arr2[j + 1];
                }
                size--;
                i--;
            } else {
                count++;
            }
        }
        if (count == size) {
            System.out.println("X ban muon xoa khong ton tai trong mang");
            for (int i = 0; i < size; i++) {
                System.out.print(arr2[i] + " ");
            }
        } else {
            System.out.println("Sau khi xoa x:");
            for (int i = 0; i < size; i++) {
                System.out.print(arr2[i] + " ");
            }
            System.out.println();
        }

        // phan 3
        System.out.println("\n=== CAU 3 ===");
        System.out.print("Nhap n (mang A): ");
        int nA = sc.nextInt();
        if (nA <= 0) {
            System.out.println("so luong phan tu trong mang phai lon hon 0");
            return;
        }
        int[] A = new int[nA];
        System.out.println("Nhap mang A:");
        for (int i = 0; i < nA; i++) {

            A[i] = sc.nextInt();

        }
        System.out.print("Nhap m (mang B): ");
        int nB = sc.nextInt();
        if (nB <= 0) {
            System.out.println("so luong phan tu trong mang phai lon hon 0");
            return;
        }
        int[] B = new int[nB];
        System.out.println("Nhap mang B:");
        for (int i = 0; i < nB; i++) {

            B[i] = sc.nextInt();
        }
        unionArray(A, B);
    }
}