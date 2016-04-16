package main.ua.goit;

public class Main {

    static String number;
    static int system;
    static String binaryNumber;
    static String systemNumber;

    public static void main(String[] args) {

        // Enter number & system
        number = InputHelper.enterNumber();
        system = InputHelper.enterSystem();

        // Convert number to binary
        binaryNumber = Converter.toBinary(number, system);
        System.out.println("Переводим в двоичную = " + binaryNumber);

        // Convert binary to initial system
        systemNumber = Converter.fromBinary(binaryNumber, system);
        System.out.println("Переводим обратно в " + system + "-ю = " + systemNumber);
    }
}