package main.ua.goit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HideImplementetion hideImplementation = new HideImplementetion();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        String inputNumber = scanner.nextLine();
        System.out.println("В какой системе это число");
        int systemInput = scanner.nextInt();
        String result = hideImplementation.ToBinary(inputNumber,systemInput);
        System.out.println(result);
        System.out.println("Переводим назад из двоичной");
        System.out.println(hideImplementation.BinaryTo(result,systemInput));
    }
}