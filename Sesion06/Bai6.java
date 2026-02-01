package Sesion06;

public class Bai6 {

    // Class User
    static class User {
        // Thuộc tính private (đóng gói)
        private int id;
        private String username;
        private String password;
        private String email;

        // Constructor khởi tạo đầy đủ
        public User(int id, String username, String password, String email) {
            this.id = id;
            this.username = username;
            setPassword(password); // kiểm soát dữ liệu
            setEmail(email); // kiểm soát dữ liệu
        }

        // Getter
        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        // Setter kiểm soát password (không rỗng)
        public void setPassword(String password) {
            if (password != null && !password.trim().isEmpty()) {
                this.password = password;
            } else {
                System.out.println("❌ Password không được rỗng!");
            }
        }

        // Setter kiểm soát email hợp lệ (đơn giản)
        public void setEmail(String email) {
            if (email != null && email.contains("@")) {
                this.email = email;
            } else {
                System.out.println("❌ Email không hợp lệ!");
            }
        }

        // Phương thức hiển thị thông tin (ẩn password)
        public void hienThiThongTin() {
            System.out.println("ID: " + id);
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: ******");
            System.out.println("--------------------");
        }
    }

    // Hàm main
    public static void main(String[] args) {

        // User hợp lệ
        User u1 = new User(1, "son2006", "123456", "son@gmail.com");
        u1.hienThiThongTin();

        // User email sai
        User u2 = new User(2, "user02", "abc123", "email_sai");
        u2.hienThiThongTin();

        // User password rỗng
        User u3 = new User(3, "user03", "", "user03@gmail.com");
        u3.hienThiThongTin();

        // Thử set lại dữ liệu
        u3.setPassword("newpass123");
        u3.setEmail("user03@gmail.com");
        u3.hienThiThongTin();
    }
}
