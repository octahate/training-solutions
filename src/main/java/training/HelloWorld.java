package training;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        String message = "Hello World!";
        System.out.println(message);

        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in); // példányosítanunk kell egy objektumot az osztály alapján a new Scanner(System.in) utasítással, és a kapott objektumot el kell tárolni egy változóban.
        String name = scanner.nextLine(); // ezek után a Scanner objektum metódusait használva különböző típusú adatokat tudunk beolvasni.

        System.out.println("Hello " + name);

        System.out.println("Year of birth?");
        int yearOfBirth = scanner.nextInt();
        System.out.println("Year of birth: " + yearOfBirth);
        System.out.println("You are " + (2020 - yearOfBirth) + " years old.");

    }
}
