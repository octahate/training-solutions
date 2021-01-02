package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    private List <Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper){
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target){
        for (int i = 0; i < troopers.size(); i++) {
            if (name.equals(troopers.get(i).getName())){
                troopers.get(i).changePosition(target);
            }
        }
    }

    private Trooper findTrooperByName(String name) {
        for (Trooper trooper : troopers) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }
        return null;
    }

    public void moveClosestTrooper(Position target){
        Trooper closestTrooper = troopers.get(0);
        double closest = troopers.get(0).distanceFrom(target);
        for (int i = 1; i < troopers.size(); i++) {
            if (troopers.get(i).distanceFrom(target) < closest){
                closest = troopers.get(i).distanceFrom(target);
                closestTrooper = troopers.get(i);
            }
        } closestTrooper.changePosition(target);
    }
}
