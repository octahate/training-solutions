package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        client.name = scanner.nextLine();
        System.out.println("Enter your birth year:");
        client.year = scanner.nextInt();
        System.out.println("Enter your address:");
        client.address = scanner.nextLine();

        System.out.println("Your data:");
        System.out.println(client.name);
        System.out.println(client.year);
        System.out.println(client.address);

    }
}
