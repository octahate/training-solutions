package activitytracker;

import java.time.LocalDateTime;

public class Activity {

    private static int counter = 0;
    private int id;
    private LocalDateTime startTime;
    private String desc;
    private Type type;

    public Activity(LocalDateTime startTime, String desc, Type type) {
        counter++;
        this.id = counter;
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

    public static int getCounter() {
        return counter;
    }

}
