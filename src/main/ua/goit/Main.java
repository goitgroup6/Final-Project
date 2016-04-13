package main.ua.goit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HideImplementetion hideImplementation = new HideImplementetion();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        String inputNumber = scanner.nextLine();
        System.out.println("В какой системе это число");
        int system = scanner.nextInt();
        String result = hideImplementation.ToBinary(inputNumber,system);
        System.out.println(result);
        System.out.println("Переводим назад из двоичной");
        System.out.println(hideImplementation.BinaryTo(result,system));
    }
}