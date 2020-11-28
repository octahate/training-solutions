package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public int getNumberOfExpired(){
        int amount = 0;
        for (int i = 0; i < products.size(); i++){
            if ((products.get(i).getExpiryDate()).isBefore(LocalDate.now())){
                amount ++;
            }
        } return amount;
    }

}
