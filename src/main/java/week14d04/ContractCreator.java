package week14d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContractCreator {

    private Contract example;

    public ContractCreator(String client, List<Integer> monthlyPrices){
        example = new Contract(client,monthlyPrices);
    }

    public Contract create(String name){
        return new Contract(name,new ArrayList<>(example.getMonthlyPrices()));
    }



    public static void main(String[] args) {

        ContractCreator cc= new ContractCreator("Peti", List.of(4,2,3));
        cc.create("Peti").getMonthlyPrices().set(1,20);

    }
}
