package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérek egy számot:");
        int number = scanner.nextInt();
        System.out.println(number % 3 == 0 ? "Osztható hárommal" : "Nem osztható hárommal");
    }
}
3