package week07d05;

public class Truck extends Vehicle{

    private int numberOfGears;
    private TransmissionType getTransmissionType;

    public Truck(int numberOfGears, TransmissionType getTransmissionType) {
        this.numberOfGears = numberOfGears;
        this.getTransmissionType = getTransmissionType;
    }
}
