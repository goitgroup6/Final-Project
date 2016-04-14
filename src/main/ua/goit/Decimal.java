package main.ua.goit;

import java.util.*;

public class Decimal {

    //      1. Ограничить ввод

    private Map<Character, Integer> map;

    public Decimal() {
        this.map = new HashMap<>();
        int k = 0;
        for (char j = '0'; j <= '9'; j++) {
            map.put(j, k++);
        }
        for (char i = 'A'; i < 'G'; i++) {
            map.put(i, k++);
        }
    }

    public int ToDecimal(String number, int system) {

        List<Integer> arrayInt = new ArrayList<>();
        CheckInputNumber check = new CheckInputNumber();

        for (int i = 0; i < number.length(); i++) {
            char symbol = number.charAt(i);
            for (Map.Entry<Character, Integer> c : map.entrySet()) {
                if (symbol == c.getKey() && check.checkNumber(c.getValue(), system) && check.filterNumber(number)) {
                    arrayInt.add(c.getValue());
                }
            }
        }
        Collections.reverse(arrayInt);
        int sum = 0;
        for (int i = 0; i < arrayInt.size(); i++) {
            sum += arrayInt.get(i) * (int) Math.pow(system, i);
        }
        return sum;
    }

    public String DecimalTo(int number, int system) {
        List<String> array = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        while (number != 0) {
            int remainder = number % system;
            for (Map.Entry<Character, Integer> c : map.entrySet()) {
                if (remainder == c.getValue()) {
                    array.add(String.valueOf(c.getKey()));
                }
            }
            number /= system;
        }
        array.forEach(stringBuilder::append);
            return stringBuilder.reverse().toString();
    }
}