package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<CatalogItem> catalogItems;

    public void addItem(CatalogItem newItem) {
        catalogItems.add(newItem);
    }

    public double averagePageNumberOver(int numbers) {
        return 0.0;
    }

    public int getAllPageNumber() {
        int pages = 0;
        for (CatalogItem item : catalogItems) {
                pages += item.numberOfPagesAtOneItem();
        }
        return pages;
    }


    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                items.add(item);
            }
        }
        return items;
    }

    public int getFullLength() {
        int minutes = 0;
        for (CatalogItem item : catalogItems) {
            minutes += item.fullLengthAtOneItem();
        }
        return minutes;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                items.add(item);
            }
        }
        return items;
    }

    public void deleteItemByRegistrationNumber(String number){
        for (CatalogItem item : catalogItems) {
            if (number.equals(item.getRegistrationNumber())){
                catalogItems.remove(item);
            }
        }
    }

    

}
