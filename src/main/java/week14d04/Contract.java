package week14d04;

import java.util.ArrayList;
import java.util.List;

public class Contract {

    private String client;
    private List<Integer> monthlyPrices;

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }

    public Contract(Contract newContract) {
        client = newContract.client;
        monthlyPrices = new ArrayList<>(monthlyPrices);
    }

    public String getClient() {
        return client;
    }

    public List<Integer> getMonthlyPrices() {
        return monthlyPrices;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "client='" + client + '\'' +
                ", monthlyPrices=" + monthlyPrices +
                '}';
    }
}
