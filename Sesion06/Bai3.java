package Sesion06;

public class Bai3 {

    // Class Product
    static class Product {
        // Thuộc tính private (đóng gói)
        private String maSP;
        private String tenSP;
        private double giaBan;

        // Constructor
        public Product(String maSP, String tenSP, double giaBan) {
            this.maSP = maSP;
            this.tenSP = tenSP;
            setGiaBan(giaBan); // dùng setter để kiểm soát
        }

        // Getter
        public String getMaSP() {
            return maSP;
        }

        public String getTenSP() {
            return tenSP;
        }

        public double getGiaBan() {
            return giaBan;
        }

        // Setter (kiểm soát giá)
        public void setGiaBan(double giaBan) {
            if (giaBan > 0) {
                this.giaBan = giaBan;
            } else {
                System.out.println("❌ Giá bán không hợp lệ! Giá phải > 0");
            }
        }

        // Phương thức hiển thị thông tin
        public void hienThiThongTin() {
            System.out.println("Mã SP: " + maSP);
            System.out.println("Tên SP: " + tenSP);
            System.out.println("Giá bán: " + giaBan);
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {

        Product sp = new Product("SP01", "Chuột Gaming", 350000);
        sp.hienThiThongTin();

        // Thử set giá không hợp lệ
        sp.setGiaBan(-100000);

        // Set lại giá hợp lệ
        sp.setGiaBan(400000);
        sp.hienThiThongTin();

        // ❌ Không thể truy cập trực tiếp:
        // sp.giaBan = -500; // LỖI do giaBan là private
    }
}
