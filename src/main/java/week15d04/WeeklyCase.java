package week15d04;

public class WeeklyCase implements Comparable<WeeklyCase> {

    String date;
    int cases;

    public WeeklyCase(String date, int cases) {
        this.date = date;
        this.cases = cases;
    }

    public String getDate() {
        return date;
    }

    public int getCases() {
        return cases;
    }


    @Override
    public int compareTo(WeeklyCase o) {
        return (o.getCases()-cases);
    }

    @Override
    public String toString() {
        return date;
    }
}
