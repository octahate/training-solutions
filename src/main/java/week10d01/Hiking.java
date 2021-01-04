package week10d01;

import java.util.ArrayList;
import java.util.List;

public class Hiking {

    List<Coordinates> coordinates;
    List<Float> heights = new ArrayList<>();

    public Hiking(List<Coordinates> allCoordinates) {
        this.coordinates = allCoordinates;
        for (Coordinates actualPlace : coordinates){
            heights.add(actualPlace.zCoordinate);
        }
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public List<Float> getHeights() {
        return heights;
    }

    public float getPlusElevation(){
        if (heights.size() < 2 ){
            throw new IllegalArgumentException("The coordinates list can't be empty or shorter than 2!");
        }
        float sum = 0;
        for (int i = 0; i < heights.size()-1; i++) {
            if (heights.get(i) < heights.get(i+1)){
                sum += ((heights.get(i+1)) - heights.get(i));
            }
        } return sum;
    }

    public static float getPlusElevation(List<Float> heights){
        if (heights.size() < 2 ){
            throw new IllegalArgumentException("The coordinates list can't be empty or shorter than 2!");
        }
        float sum = 0;
        for (int i = 0; i < heights.size()-1; i++) {
            if (heights.get(i) < heights.get(i+1)){
                sum += ((heights.get(i+1)) - heights.get(i));
            }
        } return sum;
    }
}
