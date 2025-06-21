package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class BorrowService {
    private List<BorrowRecord> borrowRecords = new ArrayList<>();
    private BookService bookService;
    private UserService userService;

    private final List<BorrowRecord> currentRecords = new ArrayList<>();
    private final List<BorrowRecord> historyRecords = new ArrayList<>();


    public BorrowService( UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    // Mượn sách
    public void borrowBook(String userId, String bookId) {
        // find book and user
        User user = userService.findById(userId);
        Book book = bookService.findById(bookId);

        if (user == null) {
            System.out.println("can not find user");
            return;
        }
        if (book == null) {
            System.out.println("can not find book");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("book is out of stock");
            return;
        }

        BorrowRecord record = new BorrowRecord(user, book);
        currentRecords.add(record);
        book.borrow();
        System.out.println("Mượn sách thành công");
    }

    // Trả sách
    public void returnBook(String userId, String bookId) {
        // tìm bản ghi mượn
        BorrowRecord found = null;
        for (BorrowRecord record : currentRecords) {
            if (record.getUser().getId().equals(userId) &&
            record.getBook().getId().equals(bookId)) {
                found = record;
                break;
            }
        }

        if (found != null) {
            currentRecords.remove(found); // xóa khỏi danh sách mượn
            found.setReturnDate(LocalDate.now()); // gán ngày trả
            historyRecords.add(found); // thêm vào lịch sử
            found.getBook().returnBook(); // cập nhật số lượng sách
            System.out.println("Trả sách thành công " + found.getBook().getTitle());
        } else {
            System.out.println("Không tìm thấy bản ghi phù hợp");
        }
    }

    // lịch sử mượn của 1 user
    public void viewHistoryByUserId(String userId) {
        boolean hasBorrow = false;

        // Lọc các bản ghi có id người dùng đúng, gom lại thành danh sách mới
        List<BorrowRecord> current = currentRecords.stream()
                .filter(record -> record.getUser().getId().equals(userId)).toList();

        List<BorrowRecord> history = historyRecords.stream()
                        .filter(record -> record.getUser().getId().equals(userId)).toList();

        if (!current.isEmpty()) {
            System.out.println("=== Sách đang mượn ===");
            current.forEach(System.out::println);
            hasBorrow = true;
        }

        if (!history.isEmpty()) {
            System.out.println("=== Sách đã trả ===");
            history.forEach(System.out::println);
            hasBorrow = true;
        }

        if (!hasBorrow) {
            System.out.println("Người dùng này chưa có lịch sử mượn sách");
            return;
        }
    }

    // lịch sử danh sách book đã và đang mượn
    public void viewAllBorrowHistory() {
        if (currentRecords.isEmpty() && historyRecords.isEmpty()) {
            System.out.println("Chưa có bản ghi mượn sách nào");
            return;
        }

        System.out.println("=== Danh sách sách đang được mượn ===");
        for (BorrowRecord record : currentRecords) {
            System.out.println(record);
        }

        System.out.println("=== Danh sách sách đã được trả ===");
        for (BorrowRecord recor : historyRecords) {
            System.out.println(recor);
        }
    }

    // danh sách book đang mượn
    public void viewCurrentBorrowedBoods() {
        if (currentRecords.isEmpty()) {
            System.out.println("Hiện không có sách nào đang được mượn.");
            return;
        }

        System.out.println("\n--- Danh sách sách đang được mượn ---");
        for (BorrowRecord record : currentRecords) {
            System.out.println("-Người dùng: " + record.getUser().getName()
            + " | Sách: " + record.getBook().getTitle()
            + " | Ngày mượn: " + record.getBorrowDate());
        }
    }

    // trả về các bản ghi mượn sách hiện tại
    public List<BorrowRecord> getCurrentRecords() {
        return currentRecords;
    }

    // debug
//    public List<BorrowRecord> getCurrentRecords() {
//        return currentRecords;
//    }
//    public List<BorrowRecord> getHistoryRecords() {
//        return historyRecords;
//    }

}
