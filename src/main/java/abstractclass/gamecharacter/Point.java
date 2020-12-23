package abstractclass.gamecharacter;

public class Point {

    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distance(Point otherPoint) {
        return (long) Math.sqrt(Math.pow((double)x - otherPoint.getX(), 2) + Math.pow((double)y - otherPoint.getY(), 2));
    }


}


