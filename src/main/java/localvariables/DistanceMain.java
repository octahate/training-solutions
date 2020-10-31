package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance (55.8,false);
        System.out.println(distance.getDistanceInKm() + " " + distance.isExact());
        int exact = (int) distance.getDistanceInKm();
        System.out.println(exact);

    }
}
