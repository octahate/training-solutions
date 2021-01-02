package staticattrmeth.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankTransaction {

    private long transactionValue;

    private static final long MIN = 1;
    private static final long MAX = 10_000_000;
    private static long currentMinValue = MAX;
    private static long currentMaxValue = MIN;
    private static long transactionCount = 0;
    private static BigDecimal transactionSum = new BigDecimal("0");

    public BankTransaction(long value) {
        if (value > MAX) {
            throw new IllegalArgumentException("Value too high!");
        }
        if (value < MIN) {
            throw new IllegalArgumentException("Value too low!");
        }

        transactionCount++;
        transactionSum = transactionSum.add(new BigDecimal(Long.toString(value)));

        if (value < currentMinValue){
            currentMinValue = value;}
        if (value > currentMaxValue){
            currentMaxValue = value;
        }

        transactionValue = value;
    }

    public static void initTheDay(){
        transactionCount = 0;
        currentMinValue = MAX;
        currentMaxValue = MIN;
        transactionSum = new BigDecimal("0");
    }

    public static long getCurrentMinValue() {
        if (transactionCount == 0){
            return 0;
        }
        return currentMinValue;
    }

    public static long getCurrentMaxValue(){
        if (transactionCount == 0){
            return 0;
        }
        return currentMaxValue;
    }

    public static BigDecimal averageOfTransaction(){
        return transactionCount == 0 ? new BigDecimal("0") : transactionSum.divide(new BigDecimal(Long.toString(transactionCount)), 0, RoundingMode.HALF_UP);    }

    public static BigDecimal getSumOfTrxs(){
        return transactionSum;
    }

}
