package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class BorrowService {
    private List<BorrowRecord> records = new ArrayList<>();
    private List<Book> books;
    private List<User> users;


    public BorrowService(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public void borrowBook(String userId, String bookId) {
        // find user
        User u = findUserById(userId);
        if (u == null) {
            System.out.println(" can not find user with id: " + userId);
            return;
        }

        // find book
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("can not find book with id: " + bookId);
            return;
        }

        // check book borrowed
        if (book.isBorrowed()) {
            System.out.println("book borrowed");
            return;
        }

        // tạo record và đánh dấu sách đã mượn
        BorrowRecord record = new BorrowRecord(bookId, userId, LocalDate.now());
        records.add(record);
        book.setBorrow(true);
        System.out.println("borrow success: " + book.getTitle());
    }

    public void listBorrowRecods() {
        if (records.isEmpty()) {
            System.out.println("chua cos luot muon sach");
        } else {
            for (BorrowRecord br : records) {
                System.out.println(br);
            }
        }
    }

    private Book findBookById(String id) {
        for (Book book : books) {
            if(book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    private User findUserById(String id) {
        for (User u : users) {
            if(u.getId().equalsIgnoreCase(id)) {
                return u;
            }
        }
        return null;
    }
}
