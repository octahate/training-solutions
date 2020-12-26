package interfaceextends;

public class Point {

    private final long x;
    private final long y;
    private final long z;

    public Point(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

 //   public long distance(Point otherPoint) {
 //       return (long) Math.sqrt(Math.pow((double)x - otherPoint.getX(), 2) + Math.pow((double)y - otherPoint.getY(), 2));
 //   }


}


