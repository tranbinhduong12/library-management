import models.Book;
import models.User;
import services.*;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        UserService userService = new UserService();
        BorrowService borrowService = new BorrowService(bookService.getBook(), userService.getUsers());

        while (true) {
            showMenu();
            int choice = InputUtils.getInt("Choose function");

            switch (choice) {
                case 1:
                    String id = InputUtils.getString("Input book id");
                    String title = InputUtils.getString("input title");
                    String author = InputUtils.getString("input author");
                    bookService.addBook(new Book(id, title, author));
                    break;

                case 2:
                    bookService.listBook();
                    break;
                case 3:
                    String keyword = InputUtils.getString("input keyword");
                    bookService.searchBook(keyword);
                    break;

                case 4:
                    String updateId = InputUtils.getString("input book Id");
                    String newTitle = InputUtils.getString("Input new title");
                    String newAuthor = InputUtils.getString("Input new author");
                    bookService.updateBook(updateId, newTitle, newAuthor);
                    break;

                case 5:
                    String deleteId = InputUtils.getString("Input book id delete");
                    bookService.deleteBook(deleteId);
                    break;

                case 6:
                    String userId = InputUtils.getString("Input id user");
                    String name = InputUtils.getString("Input user name");
                    String email = InputUtils.getString("Input email");
                    userService.addUser(new User(userId, name, email));
                    break;

                case 7:
                    userService.listUser();
                    break;

                case 8:
                    String borrowUserId = InputUtils.getString("Input user id");
                    String borrowBookId = InputUtils.getString("Input book id");
                    borrowService.borrowBook(borrowUserId, borrowBookId);
                    break;

                case 9:
                    borrowService.listBorrowRecods();
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
        System.out.println("0. Exit");
        System.out.println("------------------------");
    }

}
