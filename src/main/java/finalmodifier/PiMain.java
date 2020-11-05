package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        System.out.println(CircleCalculator.getPI());
        CircleCalculator circleCalculator = new CircleCalculator();
        CylinderCalculator cylinderCalculator = new CylinderCalculator();
        System.out.println(circleCalculator.calculatePerimeter(5));
        System.out.println(circleCalculator.calculateArea(5));
        System.out.println(cylinderCalculator.calculateSurfaceArea(5,2));
        System.out.println(cylinderCalculator.calculateVolume(5,2));
    }
}
