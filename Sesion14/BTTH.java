package Sesion14;

import java.util.*;

public class BTTH {

    // ================= ABSTRACT CLASS =================
    static abstract class Person {
        protected String id;
        protected String name;
        protected int age;

        public Person(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public abstract void displayInfo();
    }

    // ================= PATIENT =================
    static class Patient extends Person implements Comparable<Patient> {
        private String phone;

        public Patient(String id, String name, int age, String phone) {
            super(id, name, age);
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public int compareTo(Patient o) {
            return this.name.compareToIgnoreCase(o.name);
        }

        @Override
        public void displayInfo() {
            System.out.println(id + " - " + name + " - " + age + " - " + phone);
        }
    }

    // ================= MEDICAL RECORD =================
    static class MedicalRecord {
        private String recordId;
        private String diagnosis;
        private String date;

        public MedicalRecord(String recordId, String diagnosis, String date) {
            this.recordId = recordId;
            this.diagnosis = diagnosis;
            this.date = date;
        }

        public String getRecordId() {
            return recordId;
        }

        public String getDiagnosis() {
            return diagnosis;
        }

        public String getDate() {
            return date;
        }

        @Override
        public String toString() {
            return recordId + " - " + diagnosis + " - " + date;
        }
    }

    // ================= INTERFACE =================
    interface Manageable<T> {
        void add(T t);

        void update(String id);

        void delete(String id);

        void displayAll();
    }

    // ================= PATIENT SERVICE =================
    static class PatientService implements Manageable<Patient> {

        private Set<Patient> patients = new HashSet<>();
        private Scanner sc;

        public PatientService(Scanner sc) {
            this.sc = sc;
        }

        @Override
        public void add(Patient p) {
            for (Patient patient : patients) {
                if (patient.getId().equals(p.getId())) {
                    System.out.println("ID đã tồn tại!");
                    return;
                }
            }
            patients.add(p);
            System.out.println("Thêm thành công!");
        }

        @Override
        public void update(String id) {
            for (Patient p : patients) {
                if (p.getId().equals(id)) {
                    System.out.print("Tên mới: ");
                    p.name = sc.nextLine();
                    System.out.print("Tuổi mới: ");
                    p.age = Integer.parseInt(sc.nextLine());
                    System.out.println("Cập nhật thành công!");
                    return;
                }
            }
            System.out.println("Không tìm thấy!");
        }

        @Override
        public void delete(String id) {
            patients.removeIf(p -> p.getId().equals(id));
            System.out.println("Đã xóa (nếu tồn tại).");
        }

        @Override
        public void displayAll() {
            if (patients.isEmpty()) {
                System.out.println("Danh sách trống!");
                return;
            }
            patients.forEach(Patient::displayInfo);
        }

        public void searchByName(String keyword) {
            for (Patient p : patients) {
                if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                    p.displayInfo();
                }
            }
        }

        public void sortByAge() {
            List<Patient> list = new ArrayList<>(patients);
            list.sort(Comparator.comparingInt(Patient::getAge));
            list.forEach(Patient::displayInfo);
        }

        public void sortById() {
            List<Patient> list = new ArrayList<>(patients);
            list.sort(Comparator.comparing(Patient::getId));
            list.forEach(Patient::displayInfo);
        }

        public Set<Patient> getPatients() {
            return patients;
        }
    }

    // ================= RECORD SERVICE =================
    static class MedicalRecordService {

        private Map<String, List<MedicalRecord>> recordMap = new HashMap<>();

        public void addRecord(String patientId, MedicalRecord record) {
            recordMap.computeIfAbsent(patientId, k -> new ArrayList<>()).add(record);
            System.out.println("Thêm hồ sơ thành công!");
        }

        public void viewRecords(String patientId) {
            List<MedicalRecord> list = recordMap.get(patientId);
            if (list == null || list.isEmpty()) {
                System.out.println("Không có hồ sơ!");
                return;
            }
            list.forEach(System.out::println);
        }

        public void deleteRecord(String patientId, String recordId) {
            List<MedicalRecord> list = recordMap.get(patientId);
            if (list != null) {
                list.removeIf(r -> r.getRecordId().equals(recordId));
                System.out.println("Đã xóa hồ sơ.");
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientService patientService = new PatientService(sc);
        MedicalRecordService recordService = new MedicalRecordService();

        while (true) {
            System.out.println("\n========= QUẢN LÝ PHÒNG KHÁM =========");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Cập nhật bệnh nhân");
            System.out.println("3. Xóa bệnh nhân");
            System.out.println("4. Hiển thị bệnh nhân");
            System.out.println("5. Thêm hồ sơ");
            System.out.println("6. Xem hồ sơ");
            System.out.println("7. Sắp xếp theo tuổi");
            System.out.println("8. Tìm theo tên");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    patientService.add(new Patient(id, name, age, phone));
                    break;

                case 2:
                    System.out.print("Nhập ID cần cập nhật: ");
                    patientService.update(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nhập ID cần xóa: ");
                    patientService.delete(sc.nextLine());
                    break;

                case 4:
                    patientService.displayAll();
                    break;

                case 5:
                    System.out.print("Patient ID: ");
                    String pid = sc.nextLine();
                    System.out.print("Record ID: ");
                    String rid = sc.nextLine();
                    System.out.print("Diagnosis: ");
                    String diag = sc.nextLine();
                    System.out.print("Date: ");
                    String date = sc.nextLine();
                    recordService.addRecord(pid, new MedicalRecord(rid, diag, date));
                    break;

                case 6:
                    System.out.print("Patient ID: ");
                    recordService.viewRecords(sc.nextLine());
                    break;

                case 7:
                    patientService.sortByAge();
                    break;

                case 8:
                    System.out.print("Nhập tên cần tìm: ");
                    patientService.searchByName(sc.nextLine());
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}