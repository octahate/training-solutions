package debug.employees;

import debug.employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees;

    public Company (List<Employee> employees){
        this.employees = employees;
    }
    public addEmployee (Employee employee){
        employees.add(employee);
    }

    public Employee findEmployeeByName (String name) {
        for (Employee worker: employees) {
            if (worker.getName().equals(name)) {
                return worker;
            }
        }
        return null;
    }
    public List <String> listEmployeeNames() {
        List <String> names = new ArrayList<>();
        for (Employee employee: employees) {
            names.add(employee.getName());
        }
        return names;
    }
}
