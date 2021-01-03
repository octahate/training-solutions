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

    public double distance (Point other){
        return Math.round(Math.sqrt((Math.pow((other.getX() - this.x),2) + (Math.pow((other.getY() - this.y),2)))));
    }

}


