package immutable;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    private List<Satellite> tracedSatellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite){
        tracedSatellites.add(satellite);
         }

    @Override
    public String toString() {
        return tracedSatellites.toString();
    }
}
