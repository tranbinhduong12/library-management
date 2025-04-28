package services;

import models.Book;

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

    public void deleteBook(String id) {
        for (Book book : books) {
            if(book.getId().equals(id)) {
                books.remove(book);
                System.out.println("delete success");
                return;
            }
        }
        System.out.println("can not find book");
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

    public Book findById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

}
