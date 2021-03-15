package intromethods.employee;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Peter", 31, 200000);
        System.out.println(emp1.toString());
        emp1.raiseSalary(30000);
        System.out.println(emp1.toString());
    }
}
