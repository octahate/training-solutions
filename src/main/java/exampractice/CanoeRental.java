package exampractice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CanoeRental implements Comparable<CanoeRental> {
    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double calculateRentalSum(LocalDateTime endTime) {
        double multiplier;
        switch (canoeType.name()) {
            case "RED":
                multiplier = 1.0;
                break;
            case "GREEN":
                multiplier = 1.2;
                break;
            case "BLUE":
                multiplier = 1.5;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + canoeType.name());
        }
        return Duration.between(startTime, endTime).toHours() * multiplier * 5000.0;
    }


    @Override
    public String toString() {
        return "CanoeRental{" +
                "name='" + name + '\'' +
                ", canoeType=" + canoeType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public int compareTo(CanoeRental o) {
        return o.getStartTime().compareTo(startTime);
    }
}
