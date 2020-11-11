package numbers;

import javax.script.ScriptContext;
import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("kör1?");
        int circle1 = scanner.nextInt();
        Circle circleone = new Circle(circle1);
        System.out.println("kör2?");
        int circle2 = scanner.nextInt();
        Circle circletwo = new Circle(circle2);
        System.out.println(circleone.area());
        System.out.println(circleone.perimeter());
        System.out.println(circletwo.area());
        System.out.println(circletwo.perimeter());


    }
}
