package menu;

import services.*;
import utils.InputUtils;

public class MenuManager {
    public static void showMainMenu(BookService bookService, UserService userService, BorrowService borrowService) {
        while(true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Quản lý sách");
            System.out.println("2. Quản lý người dùng");
            System.out.println("3. Mượn / Trả sách");
            System.out.println("0. Thoát");

            int choice = utils.InputUtils.getInt("Chọn");

            switch (choice) {
                case 1 ->  BookMenu.show(bookService, borrowService);
                case 2 -> UserMenu.show(userService, borrowService);
                case 3 -> BorrowMenu.show(borrowService);
                case 0 -> {
                    System.out.println("Good bye");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
