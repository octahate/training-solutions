package week07d05;

public class Car extends Vehicle {
    private int numberOfGears;
    private TransmissionType getTransmissionType;

    public Car (int numberOfGears, TransmissionType getTransmissionType) {
        this.numberOfGears = super.numberOfGears;
        this.getTransmissionType = TransmissionType.AUTOMATIC;
    }
}