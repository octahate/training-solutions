package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    private List<Satellite> tracedSatellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite == null){
            throw new NullPointerException("Parameter must not be null!");
        }
        tracedSatellites.add(satellite);
    }
    public Satellite findSatelliteByRegisterIdent(String registerIdent){
        if (registerIdent.equals(null) || registerIdent.isBlank()){
            throw new NullPointerException("It can't be empty!");
        }
        for (Satellite findit: tracedSatellites){
            if(findit.getRegisterIdent().equals(registerIdent)){
                return findit;
            }
        } throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
    }

    @Override
    public String toString() {
        return tracedSatellites.toString();
    }
}
