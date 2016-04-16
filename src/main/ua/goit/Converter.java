package main.ua.goit;


import java.util.*;

public class Converter {

    private static final List<Character> VALID_CHARS = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f');

    //MAP - таблица преобразования строкового представления чисел в десятичную систему
    private static final HashMap<Character, Integer> MAP = new HashMap<>();

    private static final HashMap<Integer, Character> MAP_INV = new HashMap<>();

    //Инициализация MAP
    static {
        for (Character sym : VALID_CHARS) MAP.put(sym, VALID_CHARS.indexOf(sym));
        //VALID_CHARS.forEach(sym -> MAP.put(sym, VALID_CHARS.indexOf(sym)) );
        for (Character sym : VALID_CHARS) MAP_INV.put(VALID_CHARS.indexOf(sym), sym);
    }

    public static Integer toDecimal(String value, Integer base) {
        Integer result = 0;
        List<Integer> arrayInt = new ArrayList<>();
        // Разбиваем строку на символы и заполняем массив Integer значениями из MAP
        for (Character sym : value.toLowerCase().toCharArray()) arrayInt.add(MAP.get(sym));
        //Меняем последовательность элементов массива последний - первый
        Collections.reverse(arrayInt);
        //переводим в десятичное число
        int i = 0;
        for (Integer dig : arrayInt) result += dig * (int) Math.pow(base, i++);

        return result;
    }

    public static String DecimalTo(Integer value, Integer base) {
        String result = "";
        List<Character> array = new ArrayList<>();
        while (value != 0) {
            array.add(MAP_INV.get(value % base));
            value /= base;
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

    // Converts any value to binary
    public static String toBinary(String value, Integer base) {
        return DecimalTo(toDecimal(value, base), 2);
    }

    // Converts binary to any value
    public static String fromBinary(String value, Integer base) {
        return DecimalTo(toDecimal(value, 2), base);
    }

//    public static boolean isValueInBound(String param, Integer base){
//        return true;
//    }
//
//    // Проверка корректности строки ввода
//    public static boolean isValidValue(String param, Integer base) {
//        //return Arrays.asList(param).forEach( s -> VALID_CHARS.contains(s));
//
//        for(Character s : param.toCharArray()){
//            if (!VALID_CHARS.contains(s) || MAP.get(s) >= base) return false;
//        }
//
//        return true;
//    }
}