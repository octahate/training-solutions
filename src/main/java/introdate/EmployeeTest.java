package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a dolgozó nevét:");
        String name = scanner.nextLine();
        System.out.println("Add meg a dolgozó születési évét:");
        int year = scanner.nextInt();
        System.out.println("Add meg a dolgozó születési hónapját:");
        int month = scanner.nextInt();
        System.out.println("Add meg a dolgozó születésének napját:");
        int day = scanner.nextInt();

        Employee employee = new Employee(year,month,day,name);
        System.out.println("A dolgozó adatai:");
        System.out.println(employee.getName());
        System.out.println(employee.getDateOfBirth());
        System.out.println("Belépett:");
        System.out.println(employee.getBeginEmployment());
    }
}
