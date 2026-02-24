package Sesion09;

public class Bai5 {

    // ===== Lớp Config chứa hằng số =====
    static class Config {
        public static final double MAX_SCORE = 10.0;
        public static final double MIN_SCORE = 0.0;
    }

    public static void main(String[] args) {

        double score = 8.5;

        System.out.println("Điểm hiện tại: " + score);
        System.out.println("Điểm tối đa: " + Config.MAX_SCORE);
        System.out.println("Điểm tối thiểu: " + Config.MIN_SCORE);

        // Kiểm tra điểm hợp lệ
        if (score >= Config.MIN_SCORE && score <= Config.MAX_SCORE) {
            System.out.println("Điểm hợp lệ");
        } else {
            System.out.println("Điểm không hợp lệ");
        }

        // ❌ THỬ THAY ĐỔI HẰNG SỐ (SẼ LỖI BIÊN DỊCH)
        // Config.MAX_SCORE = 20.0;
    }
}
