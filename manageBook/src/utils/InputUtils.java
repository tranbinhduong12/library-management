package utils;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getString(String message) {
        System.out.println(message + ": ");
        return sc.nextLine();
    }

    public static int getInt(String message) {
        while(true) {
            try {
                System.out.print(message + ": ");
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("please, enter valid number.");
            }
        }
    }

    public static double getDouble(String message) {
        while (true) {
            try {
                System.out.print(message + ": ");
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("please, enter valid double number ");
            }
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("press enter để continue...");
        sc.nextLine();
    }


}
