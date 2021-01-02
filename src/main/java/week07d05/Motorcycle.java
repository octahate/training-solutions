package week07d05;

public class Motorcycle {

    private int numberOfGears;
    private TransmissionType getTransmissionType;

    public Motorcycle(int numberOfGears, TransmissionType getTransmissionType) {
        this.numberOfGears = numberOfGears;
        this.getTransmissionType = TransmissionType.SEQUENTIAL;
    }

}
