package immutable;

public class CelestialCoordinates {
    private final int ex;
    private final int why;
    private final int zedd;

    public CelestialCoordinates(int ex, int why, int zedd) {
        this.ex = ex;
        this.why = why;
        this.zedd = zedd;
    }

    public int getEx() {
        return ex;
    }

    public int getWhy() {
        return why;
    }

    public int getZedd() {
        return zedd;
    }

    @Override
    public String toString() {
        return "CelestialCoordinates:" +
                "x=" + ex +
                ",y=" + why +
                ",z=" + zedd ;
    }
}
