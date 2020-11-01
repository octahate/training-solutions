package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Adj meg egy időpontot! Óra?:");
    int hourOne = scanner.nextInt();
    System.out.println("Adj meg egy időpontot! Perc?:");
    int minuteOne = scanner.nextInt();
    System.out.println("Adj meg egy időpontot! Másodperc?:");
    int secondOne = scanner.nextInt();
    Time timeOne = new Time(hourOne,minuteOne,secondOne);
    System.out.println(timeOne.toString());
    System.out.println(timeOne.getInSeconds() + " másodperc");
    System.out.println("Adj meg egy időpontot! Óra?:");
    int hourTwo = scanner.nextInt();
    System.out.println("Adj meg egy időpontot! Perc?:");
    int minuteTwo = scanner.nextInt();
    System.out.println("Adj meg egy időpontot! Másodperc?:");
    int secondTwo = scanner.nextInt();
    Time timeTwo = new Time(hourTwo,minuteTwo,secondTwo);
    System.out.println(timeTwo.toString());
    System.out.println(timeTwo.getInSeconds() + " másodperc");
    System.out.println("Az első korábbi, mint a második? " + timeOne.earlierThan(timeTwo));





    }
}
