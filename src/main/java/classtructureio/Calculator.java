package classtructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String message = "Give me an integer";
        System.out.println(message + " :");
        Scanner scanner = new Scanner(System.in); // scanner változó scanner névvel, és benne egy scanner objetummal ami a konzolra ír ki
        int firstNumber = scanner.nextInt();
        String mextra = " again";
        System.out.println(message + mextra + " :");
        int secondNumber = scanner.nextInt();
        System.out.println(firstNumber + " + " +  secondNumber);
        System.out.println(firstNumber + secondNumber);

    }
}
