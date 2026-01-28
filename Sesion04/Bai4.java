package Sesion04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ma the thu vien: ");
        String maThe = sc.nextLine();
        String regex = "^[A-Z]{2}[0-9]{4}[0-9]{5}$";
        boolean hopLe = Pattern.matches(regex, maThe);
        if (hopLe) {
            System.out.println("ma the hop le");
        } else {
            System.out.println("ma the khong hop le");
            System.out.println("dinh dang dung: 2 chu hoa + 9 chu so");
            System.out.println("vi du: TV202312345");
        }

        sc.close();
    }
}
