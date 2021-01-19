package week12d02;

public class Site {

    private int side;
    private int houseNumber;
    private Fence Fence;

    public Site(int side, int houseNumber, week12d02.Fence fence) {
        this.side = side;
        this.houseNumber = houseNumber;
        Fence = fence;
    }

    public int getSide() {
        return side;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public week12d02.Fence getFence() {
        return Fence;
    }
}
