package main.ua.goit;

import java.util.*;

public class Converter {

    // Constant & list of valid chars
    private static final int BINARY_SYSTEM = 2;
    private static final List<Character> VALID_CHARS = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f');

    // Converts number to binary
    public static String toBinary(String number, Integer system) {
        String binaryNumber;
        if (system != 10) {
            Integer decimalNumber = toDecimal(number, system);
            binaryNumber = decimalTo(decimalNumber, BINARY_SYSTEM);
        } else {
            binaryNumber = decimalTo(Integer.parseInt(number), BINARY_SYSTEM);
        }

        return binaryNumber;
    }

    // Converts binary to any system
    public static String fromBinary(String binaryNumber, Integer system) {
        String number;
        if (system != 10) {
            Integer decimalNumber = toDecimal(binaryNumber, BINARY_SYSTEM);
            number = decimalTo(decimalNumber, system);
        } else {
            number = toDecimal(binaryNumber, BINARY_SYSTEM).toString();
        }

        return number;
    }

    // Converts to decimal
    private static Integer toDecimal(String number, Integer system) {
        int result = 0;
        double tmp;
        // Create Map of number symbols & their VALID_CHARS indexes
        HashMap<Character, Integer> validCharsAndTheirIndexes = new HashMap<>();
        for (Character symbol : VALID_CHARS) validCharsAndTheirIndexes.put(symbol, VALID_CHARS.indexOf(symbol));
        // Convert number to chars
        char[] charsOfNumbers = number.toLowerCase().toCharArray();
        // Create list of chars indexes
        List<Integer> listOfCharsIndexes = new ArrayList<>();
        for (char charOfNumber : charsOfNumbers) listOfCharsIndexes.add(validCharsAndTheirIndexes.get(charOfNumber));
        // Reverse list of chars indexes
        Collections.reverse(listOfCharsIndexes);
        // Convert to decimal
        int i = 0;
        for (Integer index : listOfCharsIndexes) {
            tmp = index * Math.pow(system, i++);
            result += tmp;
            if (result < result + tmp) {
                throw new NumberFormatException("Слишком большое число");
            }
        }

        return result;
    }

    // Converts from decimal to any system
    private static String decimalTo(Integer decimalNumber, Integer system) {
        String result = "";
        try {
            // Create Map of indexes & chars of VALID_CHARS
            HashMap<Integer, Character> indexesAndValidChars = new HashMap<>();
            for (Character validSymbol : VALID_CHARS)
                indexesAndValidChars.put(VALID_CHARS.indexOf(validSymbol), validSymbol);
            // Result number chars list
            List<Character> resultNumberChars = new ArrayList<>();
            while (decimalNumber != 0) {
                resultNumberChars.add(indexesAndValidChars.get(decimalNumber % system));
                decimalNumber = decimalNumber / system;
            }
            Collections.reverse(resultNumberChars);
            // Convert result number chars list to string
            for (Character s : resultNumberChars) result += (s.toString());
        } catch (Exception e) {
            System.out.println("[ERROR]:decimalTo " + e);
        }

        return result;
    }
}