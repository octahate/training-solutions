package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Catalog {

    protected List<CatalogItem> catalogItems;

    public Catalog() {
        this.catalogItems = new ArrayList<>();
    }

    public void addItem(CatalogItem newItem) {
        catalogItems.add(newItem);
    }

    public double averagePageNumberOver(int numbers) {
        if (numbers <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        int pageNumbers = 0;
        int books = 0;
        for (CatalogItem item: catalogItems){
            if (item.hasPrintedFeature() && item.numberOfPagesAtOneItem() > numbers){
                pageNumbers += item.numberOfPagesAtOneItem();
                books++;
            }
        } if (books == 0){
            throw new IllegalArgumentException("No page");
        }
        return (double) pageNumbers / books;
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

    public void deleteItemByRegistrationNumber(String number) {
        for (CatalogItem item : catalogItems) {
            if (number.equals(item.getRegistrationNumber())) {
                catalogItems.remove(item);
                return;
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria whatToFind) {
        List<CatalogItem> eureka = new ArrayList<>();

        if (whatToFind.hasContributor() && whatToFind.hasTitle()) {
            String contrib = whatToFind.getTitle();
            String title = whatToFind.getTitle();
            for (CatalogItem items : catalogItems) {
                if (items.getContributors().contains(contrib) && items.getTitles().contains(title)) {
                    eureka.add(items);
                }
            }
            if (eureka.size() > 0) {
                return eureka;
            }
        }


        if (whatToFind.hasTitle()) {
            String title = whatToFind.getTitle();
            for (CatalogItem items : catalogItems) {
                if (items.getTitles().contains(title)) {
                    eureka.add(items);
                }
            }
            if (eureka.size() > 0) {
                return eureka;
            }
        }
        if (whatToFind.hasContributor()) {
            String contrib = whatToFind.getContributor();
            for (CatalogItem items : catalogItems) {
                if (items.getContributors().contains(contrib)) {
                    eureka.add(items);
                }
            }
            if (eureka.size() > 0) {
                return eureka;
            }
        } throw new IllegalArgumentException("Can't find such thing");
    }
}

