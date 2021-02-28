package activitytracker;

import java.time.LocalDateTime;

public class TrackPoint {

    private int id;
    private LocalDateTime time;
    private long lat;
    private long lon;

    public TrackPoint(int id, LocalDateTime time, long lat, long lon) {
        this.id = id;
        this.time = time;
        if (LatLonValid(lat, lon)){
            this.lat = lat;
            this.lon = lon;
        }
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public long getLat() {
        return lat;
    }

    public long getLon() {
        return lon;
    }

    private boolean LatLonValid(double lat, double lon){
        if ((lat <= 90 || lat >= -90) && (lon <=180 || lon >= -180)){
            return true;
        }
        throw new IllegalArgumentException("Values are not valid!");
    }
}
