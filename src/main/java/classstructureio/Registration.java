package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        String nameQ = "Please tell me your name:";
        String mailQ = "Please tell me your e-mail address:";
        String credentials = "Your user data:";

        System.out.println(nameQ);
        Scanner infos = new Scanner(System.in);
        String name = infos.nextLine();
        System.out.println(mailQ);
        String email = infos.nextLine();
        System.out.println(credentials);
        System.out.println(name);
        System.out.println(email);

    }
}
