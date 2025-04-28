package models;

import java.time.LocalDate;

public class BorrowRecord {
    private User user;
    private Book book;
    private LocalDate borrowDate;

    public BorrowRecord(User user, Book book) {
        this.user = user;
        this.book = book;
        this.borrowDate = LocalDate.now();
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

    @Override
    public String toString() {
        return user.getName() + " đang mượn sách \"" + book.getTitle() + "\" từ ngày " + borrowDate;
    }
}
