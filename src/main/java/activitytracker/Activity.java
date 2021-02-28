package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {

    private int id;
    private LocalDateTime startTime;
    private String desc;
    private Type type;
    private List<TrackPoint> points = new ArrayList<>();

    public Activity(LocalDateTime startTime, String desc, Type type) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(int id, LocalDateTime startTime, String desc, Type type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public Type getType() {
        return type;
    }


    public List<TrackPoint> getPoints() {
        return points;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addAllTrackPoints(List<TrackPoint> trackPoints){
        points.addAll(trackPoints);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                '}';
    }
}
