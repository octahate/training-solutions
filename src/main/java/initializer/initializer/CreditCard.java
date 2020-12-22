package initializer.initializer;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    static final List<Rate> RATES = new ArrayList<>();
    private long balance;

    static {
        RATES.add(new Rate(Currency.HUF, 1.0));
        RATES.add(new Rate(Currency.EUR, 308.23));
        RATES.add(new Rate(Currency.SFR, 289.24));
        RATES.add(new Rate(Currency.GBP, 362.23));
        RATES.add(new Rate(Currency.USD, 289.77));
    }

    public CreditCard(long balance, Currency currency) {
        double rate = 0;
        for (int i = 0; i < RATES.size(); i++) {
            if (currency == RATES.get(i).getCurrency()) {
                rate = RATES.get(i).getConversionFactor();
            } else {
                throw new IllegalArgumentException("Currency is not defined in the list!");
            }
        }
        this.balance = Math.round(balance * rate);
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        long price = 0;
        for (int i = 0; i < RATES.size(); i++) {
            if (currency == RATES.get(i).getCurrency()) {
                price = Math.round(RATES.get(i).getConversionFactor() * amount);
            } else {
                throw new IllegalArgumentException("Currency is not defined in the list!");
            }
        }
        if (price <= balance){
            balance = balance - price;
            return true;
        }
        return false;
    }

    public boolean payment (long amount){
        return payment(amount, Currency.HUF);
    }
    //EZ ITT A LEGFONTOSABB, CSAK MEGHÍVTAM A HUFFAL, KÓD SPÓROLÁS

}