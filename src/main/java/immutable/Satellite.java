package immutable;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff){
        destinationCoordinates = new CelestialCoordinates(destinationCoordinates.getEx() + diff.getEx(),
                destinationCoordinates.getWhy() + diff.getWhy(), destinationCoordinates.getZedd() + diff.getZedd());
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }
    public String toString() {
        return registerIdent + ": " + destinationCoordinates.toString();
    }
}
