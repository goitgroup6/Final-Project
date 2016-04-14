package main.ua.goit;

public class HideImplementation {

    private static Decimal decimal = new Decimal();

    public static String ToBinary(String number,int system){
        return decimal.DecimalTo(decimal.ToDecimal(number,system),2);
    }

    // Ограничить ввод только двоичного числа
    public static String BinaryTo(String number,int system){
        return decimal.DecimalTo(decimal.ToDecimal(number,2),system);
    }
}