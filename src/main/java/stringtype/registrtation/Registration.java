package stringtype.registrtation;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserValidator uservalidator =  new UserValidator();
        System.out.println("Adj meg egy felhasználónevet:");
        String username = scanner.nextLine();
        System.out.println(uservalidator.isValidUsername(username));
        System.out.println("Adj meg egy emailt:");
        String email = scanner.nextLine();
        System.out.println(uservalidator.isValidEmail(email));
        System.out.println("Adj meg egy jelszót:");
        String password1 = scanner.nextLine();
        System.out.println("Adj meg a jelszót megint:");
        String password2 = scanner.nextLine();
        System.out.println(uservalidator.isValidPassword(password1,password2));
    }
}
