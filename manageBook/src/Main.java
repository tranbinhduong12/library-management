import models.Book;
import models.BorrowRecord;
import models.User;
import services.*;
import utils.InputUtils;
import utils.InputValidatorUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        UserService userService = new UserService();
        List<BorrowRecord> borrowRecords = new ArrayList<>();
        BorrowService borrowService = new BorrowService(userService, bookService, borrowRecords);

        while (true) {
            showMenu();
            int choice = InputUtils.getInt("Choose function");

            switch (choice) {
                case 1:
                    String id = InputValidatorUtils.getValidId("Input book id");
                    String title = InputValidatorUtils.getValidTitle("input title");
                    String author = InputValidatorUtils.getValidAuthor("input author");
                    int quantity = InputValidatorUtils.getValidQuantity("input quantity");
                    bookService.addBook(new Book(id, title, author, quantity));
                    break;

                case 2:
                    bookService.listBook();
                    break;
                case 3:
                    String keyword = InputUtils.getString("input keyword");
                    bookService.searchBook(keyword);
                    break;

                case 4:
                    String updateId = InputValidatorUtils.getValidId("input book Id");
                    String newTitle = InputValidatorUtils.getValidTitle("Input new title");
                    String newAuthor = InputValidatorUtils.getValidAuthor("Input new author");
                    bookService.updateBook(updateId, newTitle, newAuthor);
                    break;

                case 5:
                    String deleteId = InputUtils.getString("Input book id delete");
                    bookService.deleteBook(deleteId);
                    break;

                case 6:
                    String userId = InputValidatorUtils.getValidId("Input id user");
                    String name = InputValidatorUtils.getValidName("Input user name");
                    String email = InputValidatorUtils.getValidEmail("Input email");
                    userService.addUser(new User(userId, name, email));
                    break;

                case 7:
                    userService.listUser();
                    break;

                case 8:
                    String borrowUserId = InputValidatorUtils.getValidId("Input user id borrow");
                    String borrowBookId = InputValidatorUtils.getValidId("Input book id");
                    borrowService.borrowBook(borrowUserId, borrowBookId);
                    break;

                case 9:
                    borrowService.listBorrowBooks();
                    break;
                case 10:
                    String returnUserId = InputValidatorUtils.getValidId("Input user id");
                    String returnBookId = InputValidatorUtils.getValidId("Input book Id");
                    borrowService.returnBook(returnUserId, returnBookId);
                    break;

                case 0:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("choice invalid, choose again");
            }
            InputUtils.pressEnterToContinue();
        }
    }

    private static void showMenu() {
        System.out.println("----Quan ly thu vien----");
        System.out.println("1. Add book");
        System.out.println("2. Display list books");
        System.out.println("3. Search book");
        System.out.println("4. Update book");
        System.out.println("5. Delete book");
        System.out.println("6. Add user");
        System.out.println("7. List users");
        System.out.println("8. Borrow book");
        System.out.println("9. History borrow books");
        System.out.println("10. Return book");
        System.out.println("0. Exit");
        System.out.println("------------------------");
    }

}
