package Sesion05;

import java.util.Scanner;

public class miniProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Chon chuc nang: ");
            choice = readInt(sc);

            switch (choice) {
                case 1:
                    handleTwoSum(sc);
                    break;
                case 2:
                    handleMoveZeroes(sc);
                    break;
                case 3:
                    handlePalindrome(sc);
                    break;
                case 4:
                    handleReverseWords(sc);
                    break;
                case 5:
                    handleHappyNumber(sc);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);
    }

    // ================= MENU =================

    static void showMenu() {
        System.out.println("\n========= ALGORITHM MENU =========");
        System.out.println("1. Two Sum");
        System.out.println("2. Move Zeroes");
        System.out.println("3. Valid Palindrome");
        System.out.println("4. Reverse Words");
        System.out.println("5. Happy Number");
        System.out.println("0. EXIT");
        System.out.println("=================================");
    }

    // ================= HANDLERS =================

    static void handleTwoSum(Scanner sc) {
        int[] arr = inputArray(sc);

        System.out.print("Nhap target: ");
        int target = readInt(sc);

        int[] result = twoSum(arr, target);

        if (result == null) {
            System.out.println("Khong tim thay cap phu hop.");
        } else {
            System.out.println("Tim thay: i = " + result[0] + ", j = " + result[1]);
        }
    }

    static void handleMoveZeroes(Scanner sc) {
        int[] arr = inputArray(sc);

        moveZeroes(arr);

        System.out.println("Mang sau khi xu ly:");
        printArray(arr);
    }

    static void handlePalindrome(Scanner sc) {
        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine();

        boolean result = isPalindrome(s);

        System.out.println("Ket qua: " + result);
    }

    static void handleReverseWords(Scanner sc) {
        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine();

        String result = reverseWords(s);

        System.out.println("Ket qua: " + result);
    }

    static void handleHappyNumber(Scanner sc) {
        System.out.print("Nhap n: ");
        int n = readInt(sc);

        if (isHappyNumber(n))
            System.out.println("La so hanh phuc");
        else
            System.out.println("Khong phai so hanh phuc");
    }

    // ================= CORE ALGORITHMS =================

    static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    static void moveZeroes(int[] arr) {
        int pos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
                pos++;
            }
        }
    }

    static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }

    static String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");

        if (s.length() == 0)
            return "";

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0)
                sb.append(" ");
        }

        return sb.toString();
    }

    static boolean isHappyNumber(int n) {
        int[] history = new int[1000];
        int size = 0;

        while (true) {
            int sum = 0;
            int temp = n;

            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }

            if (sum == 1)
                return true;

            for (int i = 0; i < size; i++) {
                if (history[i] == sum)
                    return false;
            }

            history[size++] = sum;
            n = sum;
        }
    }

    // ================= UTIL =================

    static int[] inputArray(Scanner sc) {
        System.out.print("Nhap so phan tu: ");
        int n = readInt(sc);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = readInt(sc);
        }
        return arr;
    }

    static void printArray(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
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
