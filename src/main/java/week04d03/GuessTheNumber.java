package week04d03;


import java.util.Random;
import java.util.Scanner;


public class GuessTheNumber {
  public static void main(String[] args) {
        int random = new Random().nextInt (100) + 1;
        Scanner scanner = new Scanner(System.in);

        boolean ok = false;

        while (!ok){
            System.out.println("Kérek egy számot!");
            int guess = Integer.parseInt(scanner.nextLine());
            if (guess > random) {
                System.out.println("Kisebb!"); } else
                    if (guess < random) {
                    System.out.println("Nagyobb!");} else {
                    System.out.println("yupp!");
                    ok=true;
                }
            }
        }
    }


