package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features;
    private int price;
    private String registrationNumber;

    public CatalogItem(String registrationNumber, int price, List<Feature> features) {
        this.features = features;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<String> getContributors() {
        List<String> feats = new ArrayList<>();
        for (Feature thisOne : features) {
            feats.addAll(thisOne.getContributors());
        }
        return feats;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature thisOne : features) {
            titles.add(thisOne.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        for (Feature thisOne : features) {
            if (thisOne instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature thisOne : features) {
            if (thisOne instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int fullLengthAtOneItem() {
        for (Feature thisOne : features) {
            if (thisOne instanceof AudioFeatures) {
                return ((AudioFeatures) thisOne).getLength();
            }
        }
        return 0;
    }

     public int numberOfPagesAtOneItem() {
        for (Feature thisOne : features) {
            if (thisOne instanceof PrintedFeatures) {
                return ((PrintedFeatures) thisOne).getNumberOfPages();
            }
        }
        return 0;
    }




}
