package week11d02;

public class Ride {
    private int dayNumber;
    private int rideNumber;
    private int length;

    public Ride(int dayNumber, int rideNumber, int length) {
        if (dayNumber < 1 || dayNumber > 7){
            throw new IllegalArgumentException("The day number is not good!");
        } else {
            this.dayNumber = dayNumber;
            this.rideNumber = rideNumber;
            this.length = length;
        }
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public int getLength() {
        return length;
    }
}
