package main.ua.goit;

import java.util.Scanner;

public class Main {

    static int system;
    static String tempResult;

    public static void main(String[] args) {

        //Ввод входящего значения
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число");
        String inputNumber = scanner.nextLine();

        do {
            System.out.println("Введите систему числа (1..16)");
            while (!scanner.hasNextInt()) {
                System.out.println("Не верное число!");
                scanner.next();
            }
            system = scanner.nextInt();
        } while (system <= 0 || system > 16 );

        if ( !Converter.isValidValue(inputNumber, system)) {
            System.out.println("Введенное число не соответствует системе исчисления");
            return;
        }

        //Перевод в двоичную систему и вывод результата
        try {
            tempResult = Converter.toBinary(inputNumber, system);
        } catch (Exception e){
            return;
        }
        System.out.println("Переводим в двоичную = " + tempResult);

        //Перевод из двоичной системы в исходную и вывод результата
        System.out.println("Переводим назад из двоичной = " + Converter.fromBinary( tempResult ,system));
    }
}