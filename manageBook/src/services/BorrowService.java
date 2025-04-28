package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class BorrowService {
    private List<BorrowRecord> borrowRecors;
    private BookService bookService;
    private UserService userService;


    public BorrowService( UserService userService, BookService bookService, List<BorrowRecord> borrowRecors) {
        this.userService = userService;
        this.bookService = bookService;
        this.borrowRecors = borrowRecors;
    }

    // Mượn sách
    public void borrowBook(String userId, String bookId) {
        // find book and user
        User user = userService.findById(userId);
        Book book = bookService.findById(bookId);

        if (user != null && book != null) {
            if (book.isAvailable()) {
                BorrowRecord borrowRecord = new BorrowRecord(user, book);
                borrowRecors.add(borrowRecord);

                book.borrow();// cập nhật số lượng sách
                System.out.println("borrow success: " + book.getTitle());
            } else {
                System.out.println("sách đã hết");
            }
        } else {
            System.out.println("can not find user with id: " + userId);
        }
    }

    // Trả sách
    public void returnBook(String userId, String bookId) {
        // tìm bản ghi mượn
        BorrowRecord borrowRecordReturn = null;
        for (BorrowRecord record : borrowRecors) {
            if (record.getUser().getId().equals(userId) && record.getBook().getId().equals(bookId)) {
                borrowRecordReturn = record;
                break;
            }
        }

        if (borrowRecordReturn != null) {
            // xóa bản ghi mượn và cập nhật sách
            borrowRecors.remove(borrowRecordReturn);
            borrowRecordReturn.getBook().returnBook();// trả lại sách
            System.out.println("sách đã được trả" + borrowRecordReturn.getBook().getTitle());
        } else {
            System.out.println("không tìm thấy barn ghi mượn sách này");
        }
    }

    // lọc sách đã mượn
    public void listBorrowBooks() {
        for (BorrowRecord record : borrowRecors) {
            System.out.println("User: " + record.getUser().getName() + "| Book: " + record.getBook().getTitle());
        }
    }
}
