package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getBarcode().equals(barcode)) {
                items.remove(i);
            }
        }
    }

    public void clearBasket(){
        items.clear();
    }

    public List<Item> getItems() {
        return items;
    }
}
