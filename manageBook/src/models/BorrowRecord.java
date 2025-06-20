package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowRecord {
    private User user;
    private Book book;
    private LocalDate borrowDate; // định dang "dd/mm/yyyy"
    private LocalDate returnDate;

    private String bookId;
    private String bookTitle;
    private String userId;
    private String userName;

    public BorrowRecord(User user, Book book) {
        this.user = user;
        this.book = book;
        this.userId = user.getId();
        this.userName = user.getName();
        this.bookId = book.getId();
        this.bookTitle = book.getTitle();
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "User: " + user.getName() + " | Book: " + book.getTitle() +
                " | Mượn: " + borrowDate +
                " | Trả: " + (returnDate != null ? returnDate :  "Đang mượn");
    }
}
