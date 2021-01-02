package week07d05;

public class Vehicle {

    protected int numberOfGears;
    protected TransmissionType getTransmissionType;

    public Vehicle() {
        this.numberOfGears = 5;
        this.getTransmissionType = TransmissionType.MANUAL;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public TransmissionType getGetTransmissionType() {
        return getTransmissionType;
    }
}
