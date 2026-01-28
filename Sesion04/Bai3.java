package Sesion04;

import java.time.LocalDateTime;

public class Bai3 {
    public static void main(String[] args) {

        String[] maSach = { "s001", "s002", "s003", "s004", "s005" };
        String ngayMuon = "2024-08-01";

        long start = System.nanoTime();

        StringBuilder report = new StringBuilder();

        report.append("thoi gian tao bao cao: ")
                .append(LocalDateTime.now())
                .append("\n");

        for (int i = 0; i < maSach.length; i++) {
            report.append("ma sach: ")
                    .append(maSach[i])
                    .append(" - ngay muon: ")
                    .append(ngayMuon)
                    .append("\n");
        }

        long end = System.nanoTime();

        System.out.println(report.toString());
        System.out.println("thoi gian thuc thi (stringbuilder): " + (end - start) + " ns");
    }
}
