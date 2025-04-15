package models;

import java.time.LocalDate;

public class BorrowRecord {
    private String bookId;
    private String userId;
    private LocalDate borrowDate;

    public BorrowRecord(String bookId, String userId, LocalDate borrowDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "bookId='" + bookId +
                ", userId='" + userId +
                ", borrowDate=" + borrowDate +
                '}';
    }
}
