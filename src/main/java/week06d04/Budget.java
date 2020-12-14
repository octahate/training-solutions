package week06d04;

import java.util.List;

public class Budget {

    private List<Item> items;

    public Budget(List<Item> items) {
        this.items = items;
    }

    public Item getItemsByMonth (int month) {
        for (int i = 0; i < items.size(); i++) {
            if (month == items.get(i).getMonth()) {
                return items.get(i);
            }
        }
        return null;
    }

}
