package constructoroverloading;

public class SimpleTime {
    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this(hours, 0); // itt igazából a nagy konstruktorát hívom meg
    }

    public SimpleTime(SimpleTime time) {
        this(time.hours, time.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int difference(SimpleTime time) {
        return Math.abs((hours * 60 + minutes) - ((time.hours * 60 + minutes)));
    }

    public String toString() {
        return hours + ":" + minutes;
    }
}
