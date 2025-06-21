package utils;

// validate các fileds
public class InputValidatorUtils {
    public static String getValidId(String message) {
        while (true) {
            String id = InputUtils.getString(message);
            if (Validator.isNotEmpty(id)) return id;
            System.out.println("ID must not be empty");
        }
    }

    public static String getValidTitle(String message) {
        while (true) {
            String title = InputUtils.getString(message);
            if (Validator.isNotEmpty(title) && Validator.isValidLength(title, 200)) return title;
            System.out.println("Title must not be empty and max 200 characters.");
        }
    }

    public static String getValidAuthor(String message) {
        while(true) {
            String author = InputUtils.getString(message);
            if (Validator.isNotEmpty(author) && Validator.isValidLength(author, 100)) return author;
            System.out.println("Author must not be empty and max 100 characters.");
        }
    }

    public static String getValidName(String message) {
        while (true) {
            String name = InputUtils.getString(message);
            if (Validator.isNotEmpty(name) && Validator.isValidLength(name, 100)) return name;
            System.out.println("Name must not be empty and max 100 characters.");
        }
    }

    public static String getValidEmail(String messgae) {
        while (true) {
            String email = InputUtils.getString(messgae);
            if (Validator.isValidEmail(email)&& Validator.isValidLength(email, 200)) return email;
            System.out.println("Invalid email fomart of exceeds 200 characters.");
        }
    }

    public static int getValidQuantity(String message) {
        while (true) {
            int quantity = InputUtils.getInt(message);
            if (Validator.isPositiveInt(quantity, 100)) return quantity;
            System.out.println("Quantity must be > 0 and <= 100.");
        }
    }
}
