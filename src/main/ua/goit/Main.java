package main.ua.goit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        String inputNumber = scanner.nextLine();

        System.out.println("В какой системе это число");
        Integer system = scanner.nextInt();

        String result = HideImplementation.ToBinary(inputNumber,system);
        System.out.println(result);

        //check
        String res1 = Converter.toBinary(inputNumber, system);
        System.out.println("Converter.toBinary(" + inputNumber + ")=" + res1);

        System.out.println("Converter.fromBinary(" + res1 + ")=" + Converter.fromBinary( res1 ,system));

        System.out.println("Переводим назад из двоичной");
        System.out.println(HideImplementation.BinaryTo(result,system));
    }
}