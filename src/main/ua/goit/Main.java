package main.ua.goit;

import java.util.Scanner;

public class Main {

    static int system;

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
        String res1 = Converter.toBinary(inputNumber, system);
        System.out.println("Переводим в двоичную = " + res1);

        //Перевод из двоичной системы в исходную и вывод результата
        System.out.println("Переводим назад из двоичной = " + Converter.fromBinary( res1 ,system));
    }
}