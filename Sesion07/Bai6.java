package Sesion07;

import java.util.ArrayList;

public class Bai6 {

    // ===== MODEL: User =====
    static class User {
        public final int id; // ID bất biến
        public String username;
        public String password;

        public User(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User[id=" + id + ", name=" + username + "]";
        }
    }

    // ===== CONTROLLER / DATABASE GIẢ LẬP =====
    static class UserManager {

        // Danh sách user dùng chung cho toàn hệ thống
        public static ArrayList<User> users = new ArrayList<>();

        // Thêm user
        public static void addUser(User u) {
            users.add(u);
        }

        // Kiểm tra đăng nhập
        public static boolean checkLogin(String username, String password) {
            for (User u : users) {
                if (u.username.equals(username) && u.password.equals(password)) {
                    return true;
                }
            }
            return false;
        }

        // Hiển thị danh sách user
        public static void showUsers() {
            int index = 1;
            for (User u : users) {
                System.out.println(index + ". " + u);
                index++;
            }
        }
    }

    // ===== MAIN: KIỂM THỬ =====
    public static void main(String[] args) {

        // Tạo user
        User u1 = new User(1, "dev_a", "123456");
        User u2 = new User(2, "dev_b", "abcdef");
        User u3 = new User(3, "dev_c", "qwerty");

        // Thêm vào hệ thống
        UserManager.addUser(u1);
        UserManager.addUser(u2);
        UserManager.addUser(u3);

        System.out.println(">> Đã thêm 3 user vào hệ thống.");
        System.out.println("Danh sách hiện tại:");
        UserManager.showUsers();

        System.out.println("\n>> Kiểm tra đăng nhập:");
        System.out.println("- Login (\"dev_a\", \"123456\"): "
                + (UserManager.checkLogin("dev_a", "123456") ? "Thành công!" : "Thất bại!"));

        System.out.println("- Login (\"dev_b\", \"sai_pass\"): "
                + (UserManager.checkLogin("dev_b", "sai_pass") ? "Thành công!" : "Thất bại!"));

        // ❌ THỬ THÁCH FINAL (SẼ LỖI BIÊN DỊCH)
        // u1.id = 999;
    }
}
