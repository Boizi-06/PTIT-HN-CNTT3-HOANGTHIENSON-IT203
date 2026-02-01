package Sesion06;

public class Bai2 {

    // Class Account
    static class Account {
        String username;
        String password;
        String email;

        // Constructor khởi tạo thông tin ban đầu
        public Account(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        // Phương thức đổi mật khẩu
        public void doiMatKhau(String matKhauMoi) {
            this.password = matKhauMoi;
            System.out.println("Đổi mật khẩu thành công!");
        }

        // Phương thức hiển thị thông tin (ẩn mật khẩu)
        public void hienThiThongTin() {
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: ******");
            System.out.println("--------------------");
        }
    }

    // Hàm main
    public static void main(String[] args) {

        // Tạo đối tượng account
        Account acc = new Account(
                "son2006",
                "123456",
                "son@gmail.com");

        // Hiển thị thông tin ban đầu
        acc.hienThiThongTin();

        // Đổi mật khẩu
        acc.doiMatKhau("abc@2024");

        // Hiển thị lại sau khi đổi
        acc.hienThiThongTin();
    }
}
