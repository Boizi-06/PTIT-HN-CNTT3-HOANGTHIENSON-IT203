package Sesion13;

import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);s

        // =========================
        // CÂU 1 – XỬ LÝ CHUỖI
        // =========================
        System.out.println("Nhập chuỗi:");
        String s = sc.nextLine();

        int letters = 0, digits = 0, special = 0;

        // Đếm ký tự
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                letters++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else {
                special++;
            }
        }

        System.out.println("Chữ cái: " + letters);
        System.out.println("Chữ số: " + digits);
        System.out.println("Ký tự đặc biệt: " + special);

        // Kiểm tra chuỗi đối xứng (1 vòng lặp)
        boolean isPalindromeString = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                isPalindromeString = false;
                break;
            }
        }

        if (isPalindromeString) {
            System.out.println("Đây là chuỗi đối xứng");
        } else {
            System.out.println("Chuỗi không đối xứng");
        }

        // =========================
        // CÂU 2 – MẢNG 1 CHIỀU
        // =========================
        System.out.println("\nNhập số phần tử mảng:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Kiểm tra mảng đối xứng
        boolean isPalindromeArray = true;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) {
                isPalindromeArray = false;
                break;
            }
        }

        if (isPalindromeArray) {
            System.out.println("Mảng đối xứng");
        } else {
            System.out.println("Mảng không đối xứng");
        }

        // Tìm số xuất hiện nhiều nhất (không dùng collection)
        int maxCount = 0;
        int mostFrequent = arr[0];

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostFrequent = arr[i];
            }
        }

        System.out.println("Số xuất hiện nhiều nhất: " + mostFrequent);
        System.out.println("Số lần: " + maxCount);

        // =========================
        // CÂU 3 – TÌM CẶP TỔNG = K
        // =========================
        System.out.println("\nNhập K:");
        int K = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == K) {
                    System.out.println("Cặp tìm được: " + arr[i] + " và " + arr[j]);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        if (!found) {
            System.out.println("Không tồn tại cặp");
        }

        sc.close();
    }
}