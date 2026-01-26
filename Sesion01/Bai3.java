<<<<<<< HEAD
package Sesion01;

public class Bai3 {
    public static void main(String[] args) {

        String book1 = "Java Basic";
        String book2 = "Python Intro";

        // Hoán đổi bằng biến tạm
        String temp = book1;
        book1 = book2;
        book2 = temp;

        System.out.println("book1 = " + book1);
        System.out.println("book2 = " + book2);

        /*
         * ===== GIẢI THÍCH STACK & HEAP =====
         * 
         * BAN ĐẦU:
         * 
         * Stack: Heap:
         * book1 ────────────────▶ "Java Basic"
         * book2 ────────────────▶ "Python Intro"
         * 
         * 
         * BƯỚC 1: temp = book1;
         * 
         * Stack: Heap:
         * book1 ────────────────▶ "Java Basic"
         * book2 ────────────────▶ "Python Intro"
         * temp ────────────────▶ "Java Basic"
         * 
         * (temp chỉ trỏ tới cùng object, KHÔNG tạo chuỗi mới)
         * 
         * 
         * BƯỚC 2: book1 = book2;
         * 
         * Stack:
         * book1 ────────────────▶ "Python Intro"
         * book2 ────────────────▶ "Python Intro"
         * temp ────────────────▶ "Java Basic"
         * 
         * 
         * BƯỚC 3: book2 = temp;
         * 
         * Stack:
         * book1 ────────────────▶ "Python Intro"
         * book2 ────────────────▶ "Java Basic"
         * temp ────────────────▶ "Java Basic"
         * 
         * 
         * KẾT LUẬN:
         * 
         * - Heap KHÔNG thay đổi nội dung, vẫn chỉ có 2 object String:
         * "Java Basic" và "Python Intro"
         * 
         * - Stack thay đổi các biến tham chiếu (book1, book2, temp)
         * để trỏ tới object khác trong Heap.
         * 
         * - Java hoán đổi BẰNG CÁCH đổi địa chỉ tham chiếu,
         * KHÔNG sao chép dữ liệu chuỗi.
         */
    }
}
=======
package Sesion01;

public class Bai3 {
    public static void main(String[] args) {

        String book1 = "Java Basic";
        String book2 = "Python Intro";

        // Hoán đổi bằng biến tạm
        String temp = book1;
        book1 = book2;
        book2 = temp;

        System.out.println("book1 = " + book1);
        System.out.println("book2 = " + book2);

        /*
         * ===== GIẢI THÍCH STACK & HEAP =====
         * 
         * BAN ĐẦU:
         * 
         * Stack: Heap:
         * book1 ────────────────▶ "Java Basic"
         * book2 ────────────────▶ "Python Intro"
         * 
         * 
         * BƯỚC 1: temp = book1;
         * 
         * Stack: Heap:
         * book1 ────────────────▶ "Java Basic"
         * book2 ────────────────▶ "Python Intro"
         * temp ────────────────▶ "Java Basic"
         * 
         * (temp chỉ trỏ tới cùng object, KHÔNG tạo chuỗi mới)
         * 
         * 
         * BƯỚC 2: book1 = book2;
         * 
         * Stack:
         * book1 ────────────────▶ "Python Intro"
         * book2 ────────────────▶ "Python Intro"
         * temp ────────────────▶ "Java Basic"
         * 
         * 
         * BƯỚC 3: book2 = temp;
         * 
         * Stack:
         * book1 ────────────────▶ "Python Intro"
         * book2 ────────────────▶ "Java Basic"
         * temp ────────────────▶ "Java Basic"
         * 
         * 
         * KẾT LUẬN:
         * 
         * - Heap KHÔNG thay đổi nội dung, vẫn chỉ có 2 object String:
         * "Java Basic" và "Python Intro"
         * 
         * - Stack thay đổi các biến tham chiếu (book1, book2, temp)
         * để trỏ tới object khác trong Heap.
         * 
         * - Java hoán đổi BẰNG CÁCH đổi địa chỉ tham chiếu,
         * KHÔNG sao chép dữ liệu chuỗi.
         */
    }
}
>>>>>>> 8085f7b3ee18a489f801a88263218f896474e852
