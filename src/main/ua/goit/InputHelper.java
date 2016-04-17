package main.ua.goit;

import java.util.Scanner;

public class InputHelper {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    // Enter system
    public static int enterSystem() {
        int system = 0;
        try {
            String inputSystemText = "Введите систему счисления (3-16):";
            System.out.println(inputSystemText);
            String enteredValue = scanner.nextLine();
            while (!isSystemValid(enteredValue)) {
                System.out.println("Невалидное значение системы.\n" + inputSystemText);
                enteredValue = scanner.nextLine();
            }
            system = Integer.parseInt(enteredValue);
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e);
        }

        return system;
    }

    // Enter number
    public static String enterNumber(Integer system) {
        String enteredValue = null;
        try {
            String inputNumberText = "Введите позитивное число в выбранной системе:";
            System.out.println(inputNumberText);
            enteredValue = scanner.nextLine();
            while (!isNumberValid(enteredValue, system)) {
                System.out.println("Невалидное число.\n" + inputNumberText);
                enteredValue = scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e);
        }

        return enteredValue;
    }

    // Check system
    public static boolean isSystemValid(String enteredValue) {
        boolean result = false;
        try {
            Integer enteredSystem = Integer.parseInt(enteredValue);
            if (enteredSystem >= 3 && enteredSystem <= 16) result = true;
        } catch (NumberFormatException nfe) {
            result = false;
        }

        return result;
    }

    // Check number
    public static boolean isNumberValid(String enteredString, int system) {
        boolean result = true;
        try {
            String acceptableChars = "0123456789abcdef";
            for (Character enteredChar : enteredString.toCharArray()) {
                String symbol = enteredChar.toString().toLowerCase();
                if (!acceptableChars.substring(0, system).contains(symbol)) result = false;
            }
            // Check that number not consists of zeros
            int sum = 0;
            for (char character : enteredString.toCharArray()) sum += Character.getNumericValue(character);
            if (sum == 0) result = false;
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e);
        }

        return result;
    }
}