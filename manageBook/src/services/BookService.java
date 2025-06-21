package services;

import models.Book;
import models.BorrowRecord;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBook() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public List<Book> getBook() {
        return books;
    }

    public void updateBook(String id, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                System.out.println("update success");
                return;
            }
        }
        System.out.println("can't find id: " + id);
    }

    // Xóa sách
    public void deleteBook(String bookId, List<BorrowRecord> currentRecords) {
        Book book = findById(bookId);
        if (book == null) {
            System.out.println("can not find book" + bookId);
            return;
        }

        // Kiểm tra sách có đang được mượn k
        boolean isBeingBorrowed = currentRecords.stream()
                .anyMatch(r -> r.getBook().getId().equals(bookId));

        if (isBeingBorrowed) {
            System.out.println("Không thể xóa sách đang được mượn.");
            return;
        }

        books.remove(book);
        System.out.println("Xóa sách thành công" + book.getTitle());
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
            book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("can not find book with keyword: " + keyword);
        }
    }

    // mượn sách 
    public Book findById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    // Hiển thị sách đã hết
    public void listOutOfStockBook() {
        boolean found = false;
        for (Book book : books) {
            if (book.getQuantity() == 0) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Hiện tại không có sách nào đã hết");
        }
    }

}
