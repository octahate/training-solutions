package timesheet;

import java.io.*;
import java.util.List;

public class Company {

    private List<Employee> employees;
    private List<Project> projects;

    public Company(InputStream employeesFile, InputStream projectsFile) {
        try (DataInputStream employeeInputStream = new DataInputStream(
                new BufferedInputStream(employeesFile))) {

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}