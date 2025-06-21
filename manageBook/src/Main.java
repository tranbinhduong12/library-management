import menu.MenuManager;

import services.*;

public class Main {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        UserService userService = new UserService();
        BorrowService borrowService = new BorrowService(userService, bookService);

        MenuManager.showMainMenu(bookService, userService, borrowService);
    }
}
