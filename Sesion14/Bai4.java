package Sesion14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bai4 {

    public static void main(String[] args) {

        // Danh sách ca bệnh trong ngày
        List<String> diseases = new ArrayList<>();
        diseases.add("Cúm A");
        diseases.add("Sốt xuất huyết");
        diseases.add("Cúm A");
        diseases.add("Covid-19");
        diseases.add("Cúm A");
        diseases.add("Sốt xuất huyết");

        // Dùng TreeMap để vừa đếm vừa tự sắp xếp theo Alphabet
        Map<String, Integer> report = new TreeMap<>();

        // Thống kê số lượng
        for (String disease : diseases) {
            if (report.containsKey(disease)) {
                report.put(disease, report.get(disease) + 1);
            } else {
                report.put(disease, 1);
            }
        }

        // In báo cáo
        System.out.println("BÁO CÁO CA BỆNH:");
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}