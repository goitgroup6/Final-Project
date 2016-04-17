package test.ua.goit;

import main.ua.goit.InputHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputHelperTest {

    @Test
    public void isSystemValid1() {
        String system1 = "16";
        String system2 = "3";
        String system3 = "17";
        String system4 = "2";
        String system5 = "0";
        boolean expectedTrue = true;
        boolean expectedFalse = false;

        boolean result1 = InputHelper.isSystemValid(system1);
        boolean result2 = InputHelper.isSystemValid(system2);
        boolean result3 = InputHelper.isSystemValid(system3);
        boolean result4 = InputHelper.isSystemValid(system4);
        boolean result5 = InputHelper.isSystemValid(system5);

        assertEquals(expectedTrue, result1);
        assertEquals(expectedTrue, result2);
        assertEquals(expectedFalse, result3);
        assertEquals(expectedFalse, result4);
        assertEquals(expectedFalse, result5);
    }

    @Test
    public void isNumberValid() {
        String number1 = "10";
        String number2 = "1F";
        String number3 = "0";
        String number4 = "-10";
        String number5 = "1f";
        int system1 = 10;
        int system2 = 16;
        int system3 = 10;
        int system4 = 10;
        int system5 = 10;
        boolean expectedTrue = true;
        boolean expectedFalse = false;

        boolean result1 = InputHelper.isNumberValid(number1, system1);
        boolean result2 = InputHelper.isNumberValid(number2, system2);
        boolean result3 = InputHelper.isNumberValid(number3, system3);
        boolean result4 = InputHelper.isNumberValid(number4, system4);
        boolean result5 = InputHelper.isNumberValid(number5, system5);

        assertEquals(expectedTrue, result1);
        assertEquals(expectedTrue, result2);
        assertEquals(expectedFalse, result3);
        assertEquals(expectedFalse, result4);
        assertEquals(expectedFalse, result5);
    }
}