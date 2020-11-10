package enumtype.week;

import java.util.Scanner;

public class WorkdayCalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("melyik nap?");
        String day = scanner.nextLine();
        System.out.println("hány napot utána?");
        int amount = scanner.nextInt();

        int x = 5;
        int y = 2;
        int z = x++ + (x - 4) * y - 2;
        System.out.println(x + " " + z);


    }
}
