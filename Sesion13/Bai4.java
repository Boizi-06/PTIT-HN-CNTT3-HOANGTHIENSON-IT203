package Sesion09;

public class Bai4 {

    static class ClassRoom {

        // Biến static - quỹ chung của lớp
        private static double classFund = 0;

        // Biến instance - tên sinh viên
        private String studentName;

        // Constructor
        public ClassRoom(String studentName) {
            this.studentName = studentName;
        }

        // Sinh viên đóng tiền vào quỹ lớp
        public void payFund(double amount) {
            classFund += amount;
            System.out.println(studentName + " đã đóng: " + amount);
        }

        // Xem tổng quỹ lớp
        public static void showClassFund() {
            System.out.println("Tổng quỹ lớp hiện tại: " + classFund);
        }
    }

    public static void main(String[] args) {

        ClassRoom s1 = new ClassRoom("An");
        ClassRoom s2 = new ClassRoom("Bình");
        ClassRoom s3 = new ClassRoom("Cường");

        s1.payFund(100000);
        s2.payFund(150000);
        s3.payFund(200000);

        ClassRoom.showClassFund();
    }
}
