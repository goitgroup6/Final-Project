package main.ua.goit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Ввод входящего значения
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        String inputNumber = scanner.nextLine();

        System.out.println("В какой системе это число");
        Integer system = scanner.nextInt();

        //Перевод в двоичную систему и вывод результата

        //старая реализация, не менять, УДАЛИТЬ
        String result = HideImplementation.ToBinary(inputNumber,system);
        System.out.println(result);
        //старая реализация, не менять, УДАЛИТЬ

        //check
        String res1 = Converter.toBinary(inputNumber, system);
        System.out.println("Converter.toBinary(" + inputNumber + ")=" + res1);

        //Перевод из двоичной системы в исходную и вывод результата
        System.out.println("Переводим назад из двоичной");

        System.out.println("Converter.fromBinary(" + res1 + ")=" + Converter.fromBinary( res1 ,system));

        //старая реализация, не менять, УДАЛИТЬ
        System.out.println(HideImplementation.BinaryTo(result,system));
        //старая реализация, не менять, УДАЛИТЬ
    }
}