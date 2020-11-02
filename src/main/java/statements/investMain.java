package statements;

import java.util.Scanner;

public class investMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mennyit fektetnél be?");
        int fund = scanner.nextInt();
        System.out.println("Milyen kamatlábbal?");
        int interestRate = scanner.nextInt();

        Investment investment = new Investment(fund,interestRate);

        System.out.println("Befektetés összege:");
        System.out.println(investment.getFund());
        System.out.println("Kamatláb:");
        System.out.println(investment.getInterestRate());

        System.out.println("Hány napra fektetnél be?");

        int days = scanner.nextInt();

        System.out.println("Hozam" + days + "napra:");

        System.out.println(investment.close(days));

        System.out.println("Hozam" + days + "napra:");

        System.out.println(investment.close(days));





    }
}
