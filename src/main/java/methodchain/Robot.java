package methodchain;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance;
    private int azimut;
    private List<NavigationPoint> places = new ArrayList<>();

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public Robot go(int meter) {
        distance = distance + meter;
        return this;
    }

    public Robot rotate(int angle) {
        azimut = azimut + angle;
        return this;
    }

    public Robot registerNavigationPoint() {
        azimut = azimut;
        distance = distance;
        NavigationPoint current = new NavigationPoint(this.distance, this.azimut);
        places.add(current);
        return this;
    }

    public String getNavigationList() {
        StringBuilder list = new StringBuilder();
        list.append("[");
        for (int i = 0; i < places.size(); i++) {
            list.append(places.get(i).toString());
            list.append(", ");
        }
        list.deleteCharAt(list.length()-2);
        list.deleteCharAt(list.length()-1);
        list.append("]");
        return list.toString();
    }

}
