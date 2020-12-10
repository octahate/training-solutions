package methodchain;

public class Robot {
    private int distance;
    private int azimut;

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public Robot go(int meter){
        distance = distance + meter;
        return this;
    }

    public Robot rotate(int angle){
        azimut = azimut + angle;
        return this;
    }
}
