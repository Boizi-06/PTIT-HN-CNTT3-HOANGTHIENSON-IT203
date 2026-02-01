package Sesion06;

public class Bai5 {

    // Class Book
    static class Book {
        String maSach;
        String tenSach;
        double gia;

        // Constructor: tham số TRÙNG TÊN với thuộc tính
        public Book(String maSach, String tenSach, double gia) {
            // this đại diện cho đối tượng hiện tại
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.gia = gia;
        }

        // Phương thức hiển thị thông tin sách
        public void hienThiThongTin() {
            System.out.println("Mã sách: " + maSach);
            System.out.println("Tên sách: " + tenSach);
            System.out.println("Giá: " + gia);
            System.out.println("--------------------");
        }
    }

    // Hàm main
    public static void main(String[] args) {

        Book b1 = new Book("S01", "Lập trình Java", 120000);
        Book b2 = new Book("S02", "OOP Cơ bản", 95000);

        b1.hienThiThongTin();
        b2.hienThiThongTin();
    }
}
