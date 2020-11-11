package numbers;

public class Circle {
    private int diameter;
    public final double PI = 3.14;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter (){
        return 2 * PI * (diameter/2);
    }

    public double area (){
        return Math.pow((diameter/2),2) * PI;
    }

}
