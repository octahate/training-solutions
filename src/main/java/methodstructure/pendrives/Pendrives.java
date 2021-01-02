package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive currentBest = null;
        for (int i = 0; i < pendrives.size() - 1; i++) {
            if ((pendrives.get(i).comparePricePerCapacity(pendrives.get(i + 1))) > 1) {
                currentBest = pendrives.get(i+1);
            } else {
                currentBest = pendrives.get(i);
            }
        } return currentBest;
    }

    Pendrive cheapest(List<Pendrive> pendrives){
        Pendrive currentBest = pendrives.get(0);
        for (int i = 1; i < pendrives.size()-1; i++) {
            if (currentBest.cheaperThan(pendrives.get(i))) {
            } else {
                currentBest = pendrives.get(i);
            }
        } return currentBest;
    }

    void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity){
        for (int i = 0; i < pendrives.size(); i++) {
            if (pendrives.get(i).getCapacity() == capacity){
                pendrives.get(i).risePrice(percent);
            }
        }
    }

}
