package main.ua.goit;

public class Main {

    public static void main(String[] args) {

        try {
            // Enter number & system
            Integer system = InputHelper.enterSystem();
            String number = InputHelper.enterNumber(system);

            // Convert number to binary
            String binaryNumber = Converter.toBinary(number, system);
            System.out.println("Переводим в двоичную = " + binaryNumber);

            // Convert binary to initial system
            String systemNumber = Converter.fromBinary(binaryNumber, system);
            System.out.println("Переводим обратно в " + system + "-ю = " + systemNumber);
        } catch (NumberFormatException npe) {
            System.out.println("Слишком большое число");
        } catch (Exception e) {
            System.out.println("[ERROR MAIN]" + e);
        }
    }
}