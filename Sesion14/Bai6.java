package Sesion14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Patient2 {
    String name;
    int age;
    String department; // Khoa điều trị

    public Patient2(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class Bai6 {

    public static void main(String[] args) {

        // ===== Danh sách bệnh nhân ban đầu =====
        List<Patient2> patients2 = new ArrayList<>();
        patients2.add(new Patient2("Lan", 20, "Tim mạch"));
        patients2.add(new Patient2("Hùng", 25, "Nội tiết"));
        patients2.add(new Patient2("Mai", 30, "Tim mạch"));

        // ===== Map gom nhóm theo khoa =====
        Map<String, List<Patient2>> departmentMap = new HashMap<>();

        for (Patient2 p : patients2) {

            // Nếu khoa chưa tồn tại -> tạo list mới
            if (!departmentMap.containsKey(p.department)) {
                departmentMap.put(p.department, new ArrayList<>());
            }

            // Thêm bệnh nhân vào list của khoa
            departmentMap.get(p.department).add(p);
        }

        // ===== In cấu trúc Map =====
        System.out.println("Danh sách theo từng khoa:");
        for (Map.Entry<String, List<Patient2>> entry : departmentMap.entrySet()) {
            System.out.println("Khoa " + entry.getKey() + " -> " + entry.getValue());
        }

        // ===== Tìm khoa đông nhất =====
        String maxDepartment = "";
        int maxCount = 0;

        for (Map.Entry<String, List<Patient2>> entry : departmentMap.entrySet()) {
            int size = entry.getValue().size();
            if (size > maxCount) {
                maxCount = size;
                maxDepartment = entry.getKey();
            }
        }

        System.out.println("\nKhoa " + maxDepartment + " đang đông nhất (" + maxCount + " bệnh nhân)");
    }
}