package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mi a termék neve?");
        String name = scanner.nextLine();
       // System.out.println(name);
        System.out.println("Mennyibe kerül?");
        int price = scanner.nextInt();
       // System.out.println(price);
        Product product = new Product(name,price);
        System.out.println(product.getName() + "  " + product.getPrice() + "  Ft");

    }
}
