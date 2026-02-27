package Sesion14;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Patient1 {
    String name;
    int severity; // 1-Nguy kịch, 2-Nặng, 3-Nhẹ
    int arrivalTime; // ví dụ: 800 = 8:00, 815 = 8:15

    public Patient1(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (Mức " + severity + ", đến lúc " + arrivalTime + ")";
    }
}

public class Bai5 {

    public static void main(String[] args) {

        // Tạo TreeSet với Comparator
        Set<Patient1> emergencyQueue = new TreeSet<>(new Comparator<Patient1>() {

            public int compare(Patient1 p1, Patient1 p2) {

                // So sánh severity trước
                if (p1.severity != p2.severity) {
                    return p1.severity - p2.severity;
                }

                // Nếu severity bằng nhau → so sánh arrivalTime
                return p1.arrivalTime - p2.arrivalTime;
            }
        });

        // Thêm bệnh nhân
        emergencyQueue.add(new Patient1("Bệnh nhân A", 3, 800));
        emergencyQueue.add(new Patient1("Bệnh nhân B", 1, 815));
        emergencyQueue.add(new Patient1("Bệnh nhân C", 1, 805));

        // In thứ tự xử lý
        System.out.println("Thứ tự xử lý cấp cứu:");
        for (Patient1 p : emergencyQueue) {
            System.out.println(p);
        }
    }
}