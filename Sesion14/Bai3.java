package Sesion14;

import java.util.HashSet;
import java.util.Set;

public class Bai3 {

    public static void main(String[] args) {

        // Set A: Thành phần thuốc mới
        Set<String> drug = new HashSet<>();
        drug.add("Aspirin");
        drug.add("Caffeine");
        drug.add("Paracetamol");

        // Set B: Chất bệnh nhân dị ứng
        Set<String> allergy = new HashSet<>();
        allergy.add("Penicillin");
        allergy.add("Aspirin");

        // ===== TÌM GIAO (Cảnh báo dị ứng) =====
        Set<String> warning = new HashSet<>(drug); // tạo bản sao
        warning.retainAll(allergy);

        // ===== TÌM HIỆU (Thành phần an toàn) =====
        Set<String> safe = new HashSet<>(drug); // tạo bản sao
        safe.removeAll(allergy);

        // In kết quả
        System.out.println("Cảnh báo dị ứng: " + warning);
        System.out.println("Thành phần an toàn: " + safe);
    }
}