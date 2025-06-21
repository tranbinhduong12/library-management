package menu;

import services.BorrowService;
import utils.InputUtils;
import utils.InputValidatorUtils;

public class BorrowMenu {
    public static void show(BorrowService borrowService) {
        while (true) {
            System.out.println("\n--- Mượn/ trả sách ---");
            System.out.println("1. Mượn sách");
            System.out.println("2. Trả sách");
            System.out.println("3. Xem sách đang được mượn");
            System.out.println("4. Xem lịch sử mượn");
            System.out.println("5. Xem lịch sử mượn của người dùng");
            System.out.println("0. Quay lại");

            int choice = InputUtils.getInt("Chọn");

            switch (choice) {
                case 1 -> {
                    var userId = InputValidatorUtils.getValidId("Nhập ID người dùng");
                    var bookId = InputValidatorUtils.getValidId("Nhập ID sách");
                    borrowService.borrowBook(userId, bookId);
                }

                case 2 -> {
                    var userId = InputValidatorUtils.getValidId("Nhập ID người dùng");
                    var bookId = InputValidatorUtils.getValidId("Nhập ID sách");
                    borrowService.returnBook(userId, bookId);
                }

                case 3 -> borrowService.viewCurrentBorrowedBoods();
                case 4 -> borrowService.viewAllBorrowHistory();
                case 5 -> {
                    var userId = InputValidatorUtils.getValidId("Nhập ID người dùng");
                    borrowService.viewHistoryByUserId(userId);
                }
                case 0 -> {return;}
                default -> System.out.println("Lựa chọn khộng hợp lệ");
            }
        }
    }
}
