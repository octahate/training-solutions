package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mi a kedvenc zenéd címe?:");
        song.title = scanner.nextLine();
        System.out.println("Ki a kedvenc zenéd előadója?:");
        song.band = scanner.nextLine();
        System.out.println("Mi a kedvenc zenéd hossza percben?:");
        song.length = scanner.nextInt();

        System.out.println(song.band + " - " + song.title + " (" + song.length + " perc)");

    }
}
