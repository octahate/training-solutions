package finalmodifier;

public class CylinderCalculator {
    public double calculateVolume(double r, double h){
        return CircleCalculator.getPI() * r * r * h;
    }
    public double calculateSurfaceArea(double r, double h){
        return (2 * (CircleCalculator.getPI() * r * r)) + (h * 2 * r * CircleCalculator.getPI());
    }
}
