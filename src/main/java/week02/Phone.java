package week02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("Alcatel", 25);
        Phone phone2 = new Phone("Nokia", 256);

        System.out.println(phone1.getType());
        System.out.println(phone1.getMem() + " MB");
        System.out.println(phone2.getType());

        System.out.println(phone1.getMem() + " MB");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Telefon típusa:");
        String phone3type = scanner.nextLine();
        System.out.println("Telefon memóriája:");

        int phone3mem = scanner.nextInt();
        Phone phone3 = new Phone(phone3type, phone3mem);
        System.out.println(phone3.getType());
        System.out.println(phone3.getMem() + " MB");



    }
}
