package menu;

import models.User;
import services.UserService;
import services.BorrowService;
import utils.InputUtils;
import utils.InputValidatorUtils;

public class UserMenu {
    public static void show(UserService userService, BorrowService borrowService) {
        while (true) {
            System.out.println("\n--- Quản lý người dùng ---");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Cập nhập người dùng");
            System.out.println("3. Xóa người dùng");
            System.out.println("4. Tìm kiếm người dùng");
            System.out.println("5. Hiển thị tất cả người dùng");
            System.out.println("0. quay lại");

            int choice = InputUtils.getInt("Chọn");
            switch (choice) {
                case 1 -> {
                    var id = InputValidatorUtils.getValidId("Nhập ID người dùng");
                    var name = InputValidatorUtils.getValidName("Nhập tên");
                    var email = InputValidatorUtils.getValidEmail("Nhập email");
                    userService.addUser(new User(id, name, email));
                }

                case 2 -> {
                    var id = InputValidatorUtils.getValidId("Nhập Id người dùng cần cập nhật");
                    var name = InputValidatorUtils.getValidName("Tên mới");
                    var email = InputValidatorUtils.getValidEmail("Email mới");
                    userService.updateUser(id, name, email);
                }

                case 3 -> {
                    var id = InputValidatorUtils.getValidId("Nhập Id người dùng cần xóa");
                    userService.deleteUser(id, borrowService.getCurrentRecords());
                }

                case 4 -> {
                    var keyword = InputUtils.getString("Nhập từ khóa tìm kiếm");
                    userService.searchUser(keyword);
                }

                case 5 -> userService.listUser();
                case 0 -> {return;}
                default -> System.out.println("Lựa chọn không hợp lệ");


            }
        }
    }
}
