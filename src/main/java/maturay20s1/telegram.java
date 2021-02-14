package maturay20s1;

import java.time.LocalTime;

public class telegram {

    private String location;
    private LocalTime date;
    private boolean isWindVariable;
    private String windDirection;
    private String windStrength;
    private int temperature;

    public telegram(String location, LocalTime date, boolean isWindVariable, String windDirection, String windStrength, int temperature) {
        this.location = location;
        this.date = date;
        this.isWindVariable = isWindVariable;
        this.windDirection = windDirection;
        this.windStrength = windStrength;
        this.temperature = temperature;
    }

    public telegram(String location, LocalTime date, boolean isWindVariable, String windStrength, int temperature) {
        this.location = location;
        this.date = date;
        this.isWindVariable = isWindVariable;
        this.windStrength = windStrength;
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public LocalTime getDate() {
        return date;
    }

    public boolean isWindVariable() {
        return isWindVariable;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getWindStrength() {
        return windStrength;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "telegram{" +
                "location='" + location + '\'' +
                ", date=" + date +
                ", isWindVariable=" + isWindVariable +
                ", windDirection='" + windDirection + '\'' +
                ", windStrength='" + windStrength + '\'' +
                ", temperature=" + temperature +
                '}';
    }

}
