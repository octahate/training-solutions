package intromethods.employee;

public class Employee {

    private String name;
    private int hiringYear;
    private int Salary;

    public Employee(String name, int hiringYear, int salary) {
        this.name = name;
        this.hiringYear = hiringYear;
        Salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getHiringYear() {
        return hiringYear;
    }

    public int getSalary() {
        return Salary;
    }

    public void raiseSalary(int amount){
        Salary+=amount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", hiringYear=" + hiringYear +
                ", Salary=" + Salary +
                '}';
    }
}
