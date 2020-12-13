package methodpass.troopers;

import java.util.List;

public class HeadQuarter {
    private List <Trooper> troopers;

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper){
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target){

    }

    private Trooper findTrooperByName(String name) {
        for (Trooper trooper : troopers) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }
        return null;
    }

}
