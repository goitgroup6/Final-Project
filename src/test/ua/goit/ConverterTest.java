package test.ua.goit;

import main.ua.goit.Converter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void toBinary() {
        String number1 = "100";
        String number2 = "1F";
        Integer system1 = 10;
        Integer system2 = 16;

        String expected1 = "1100100";
        String expected2 = "11111";

        String result1 = Converter.toBinary(number1, system1);
        String result2 = Converter.toBinary(number2, system2);

        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
    }

    @Test
    public void fromBinary() {
        String binaryNumber1 = "1010";
        String binaryNumber2 = "11111";
        Integer system1 = 10;
        Integer system2 = 16;

        String expected1 = "10";
        String expected2 = "1f";

        String result1 = Converter.fromBinary(binaryNumber1, system1);
        String result2 = Converter.fromBinary(binaryNumber2, system2);

        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
    }
    
    @Test(expected = NumberFormatException.class)
        public void toBinaryTest_DecimalNumber(){
        String number = "99999999999999999999";
        Integer system = 10;

        Converter.toBinary(number, system);
    }

    @Test(expected = NumberFormatException.class)
    public void toBinaryTest_ExceptDecimalNumber() {
        String number = "ffffffffff";
        Integer system = 16;

        Converter.toBinary(number, system);
    }
}
