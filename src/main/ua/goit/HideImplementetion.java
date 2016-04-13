package main.ua.goit;

public class HideImplementetion {

    private Decimal decimal = new Decimal();

    public String ToBinary(String number,int system){
        return decimal.DecimalTo(decimal.ToDecimal(number,system),2);
    }

    // Ограничить ввод только двоичного числа
    public String BinaryTo(String number,int system){
        return decimal.DecimalTo(decimal.ToDecimal(number,2),system);
    }
}