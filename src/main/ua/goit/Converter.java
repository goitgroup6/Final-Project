package main.ua.goit;


import java.util.*;

public class Converter {

    private static final List<Character> VALID_CHARS = Arrays.asList
            ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f');

    // MAP - таблица преобразования строкового представления чисел в десятичную систему
    private static final HashMap<Character, Integer> MAP = new HashMap<>();
    private static final HashMap<Integer, Character> MAP_INV = new HashMap<>();

    // MAP initialize
    static {
        for (Character sym : VALID_CHARS) MAP.put(sym, VALID_CHARS.indexOf(sym));
        for (Character sym : VALID_CHARS) MAP_INV.put(VALID_CHARS.indexOf(sym), sym);
    }

    // Converts any value to binary
    public static String toBinary(String number, Integer system) {
        Integer decimalNumber = toDecimal(number, system);
        return DecimalTo(decimalNumber, 2);
    }

    // Converts binary to any value
    public static String fromBinary(String binaryNumber, Integer system) {
        Integer decimalNumber = toDecimal(binaryNumber, 2);
        return DecimalTo(decimalNumber, system);
    }

    public static Integer toDecimal(String number, Integer system) {
        Integer result = 0;
        try {
            List<Integer> arrayInt = new ArrayList<>();
            // Разбиваем строку на символы и заполняем массив Integer значениями из MAP
            for (Character sym : number.toLowerCase().toCharArray()) arrayInt.add(MAP.get(sym));
            // Меняем последовательность элементов массива последний - первый
            Collections.reverse(arrayInt);
            // Переводим в десятичное число
            int i = 0;
            for (Integer dig : arrayInt) result += dig * (int) Math.pow(system, i++);
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
        }

        return result;
    }

    public static String DecimalTo(Integer decimalNumber, Integer system) {
        String result = "";

        List<Character> array = new ArrayList<>();
        while (decimalNumber != 0) {
            array.add(MAP_INV.get(decimalNumber % system));
            decimalNumber /= system;
        }
        Collections.reverse(array);
        try {
            for (Character s : array) result += (s.toString());
        } catch (Exception e) {
            System.out.println("Введенное число слишком большое!");
            throw new NullPointerException();
        }

        return result;
    }
}