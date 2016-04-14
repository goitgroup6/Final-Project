package main.ua.goit;

public class CheckInputNumber extends Exception {


    public boolean checkNumber(int number, int system) {
        if (number >= system) {
            throw new NumberFormatException("Ошибка: введённое значение не соответствует данной системе счисления");
        } else {
            return true;
        }
    }

    // Проверка числа на правильность вводимых знаков (не должно быть символов и букв других языков)
    public boolean filterNumber(String number) {
//        for (int i = 0; i < number.length(); i++) {
//            char symbol = number.charAt(i);
//            if ()
//            throw new NumberFormatException("Ошибка");
//        }
        return true;
    }
}