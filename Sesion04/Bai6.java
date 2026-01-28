package Sesion04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap danh gia sach: ");
        String review = sc.nextLine();
        String[] blacklist = { "xau", "te", "rac" };
        // lọc từ nhạy cảm bằng regex
        for (String badWord : blacklist) {
            Pattern pattern = Pattern.compile("(?i)" + badWord);
            Matcher matcher = pattern.matcher(review);
            StringBuffer result = new StringBuffer();
            while (matcher.find()) {
                String stars = "*".repeat(matcher.group().length());
                matcher.appendReplacement(result, stars);
            }
            matcher.appendTail(result);
            review = result.toString();
        }
        if (review.length() > 200) {
            int cutIndex = review.lastIndexOf(" ", 200);
            if (cutIndex == -1) {
                cutIndex = 200;
            }
            review = review.substring(0, cutIndex) + "...";
        }
        System.out.println("\n===== ket qua =====");
        System.out.println(review);

        sc.close();
    }
}
