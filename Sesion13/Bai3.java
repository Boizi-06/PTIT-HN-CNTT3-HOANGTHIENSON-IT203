package Sesion13;

public class Bai3 {

    // ===== Utility Class =====
    static class ScoreUtils {

        // Kiểm tra Đạt / Trượt
        public static boolean checkPass(double score) {
            return score >= 5.0;
        }

        // Tính điểm trung bình
        public static double calculateAverage(double[] scores) {
            double sum = 0;
            for (double score : scores) {
                sum += score;
            }
            return sum / scores.length;
        }
    }

    // ===== Main Program =====
    public static void main(String[] args) {

        double[] scores = { 6.5, 8.0, 4.5 };

        System.out.println("Danh sách điểm: 6.5, 8.0, 4.5");
        System.out.println("\n>> Kết quả xử lý:");

        double avg = ScoreUtils.calculateAverage(scores);
        System.out.println("- Điểm trung bình cả lớp: " + avg);

        for (double score : scores) {
            if (ScoreUtils.checkPass(score)) {
                System.out.println("- Điểm " + score + ": Đạt");
            } else {
                System.out.println("- Điểm " + score + ": Trượt");
            }
        }
    }
}
