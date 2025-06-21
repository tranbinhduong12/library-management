package utils;

import java.util.regex.Pattern;

//tạo validate
public class Validator {

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidLength(String input, int maxlength) {
        return input.length() <= maxlength;
    }

    public static boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", email);
    }

    public static boolean isPositiveInt(int value, int max) {
        return value > 0 && value <= max;
    }
}
