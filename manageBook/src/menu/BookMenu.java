package menu;

import models.Book;
import services.BookService;
import services.BorrowService;
import utils.InputUtils;
import utils.InputValidatorUtils;

public class BookMenu {
    public static void show(BookService bookService, BorrowService borrowService) {
        while(true) {
            System.out.println("\n--- Quản lý sách ---");
            System.out.println("1. Thêm sách");
            System.out.println("2. Cập nhật sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Hiển thị sách còn lại");
            System.out.println("6. Hiển thị sách đã hết");
            System.out.println("0. quay lại");

            int choice = utils.InputUtils.getInt("Chọn");

            switch (choice) {
                case 1 -> {
                    var id = InputValidatorUtils.getValidId("Nhập ID"); //var: tự động dùng kiểu dữ liệu trả về của method, có từ java 10+
                    var title = InputValidatorUtils.getValidTitle("Nhập tiêu đề");
                    var author = InputValidatorUtils.getValidAuthor("Nhập tác giả");
                    var quantity = InputValidatorUtils.getValidQuantity("Nhập số lượng");
                    bookService.addBook(new Book(id, title, author, quantity));
                }

                case 2 -> {
                    var id = InputValidatorUtils.getValidId("Nhập id");
                    var title = InputValidatorUtils.getValidTitle("Nhập tiêu đề");
                    var author = InputValidatorUtils.getValidAuthor("Nhập tác giả");
                    bookService.updateBook(id, title, author);
                }

                case 3 -> {
                    var id = InputValidatorUtils.getValidId("Nhập ID sách cần xóa");
                    bookService.deleteBook(id, borrowService.getCurrentRecords());
                }

                case 4 -> {
                    var keyword = InputUtils.getString("Từ khóa tìm kiếm");
                    bookService.searchBook(keyword);
                }

                case 5 -> bookService.listBook();
                case 6 -> bookService.listOutOfStockBook();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
