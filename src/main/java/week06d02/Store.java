package week06d02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Store {
    private List<Product> inventory;

    public Store(List<Product> inventory) {
        this.inventory = inventory;
    }

    public void getProductByCategoryName(Categories cat){
        for (int i = 0; i < inventory.size(); i++){
            int amount = 0;
            if (inventory.get(i).getCategory() == cat){
                amount++;
            }
            System.out.println(amount);
        }
    }

    public static void main(String[] args) {
        Store store = new Store(Arrays.asList(new Product("alma", Categories.FROZEN, 3)));
        store.getProductByCategoryName(Categories.FROZEN);
    }
}
