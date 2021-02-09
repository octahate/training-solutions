package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {

    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<TimeSheetItem> timeSheetItems = new ArrayList<>();
    private List<RiportLine> riportLines = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Company(InputStream employeesFile, InputStream projectsFile) {
        readEmployees(employeesFile);
        readProjects(projectsFile);
    }

    private void readEmployees(InputStream employeesFile) {
        try (BufferedReader employeeInputStream = new BufferedReader(new InputStreamReader(employeesFile))) {
            String line;
            while ((line = employeeInputStream.readLine()) != null) {
                employees.add(new Employee(line.split(" ")[0], line.split(" ")[1]));
            }
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Cannot read" + employeesFile);
        }
    }

    private void readProjects(InputStream projectsFile) {
        try (BufferedReader projectsInputStream = new BufferedReader(new InputStreamReader(projectsFile))) {
            String line;
            while ((line = projectsInputStream.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Cannot read" + projectsFile);
        }
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
        riportLines.add(new RiportLine(project, (long) endDate.getHour() - beginDate.getHour()));

    }

    public void printToFile(String employeeName, int year, int month, Path file) {

        Employee inputEmployee = new Employee(employeeName.substring(0, employeeName.indexOf(" ")),
                employeeName.substring(employeeName.indexOf(" ") + 1));
        isItEvenOurWorker(inputEmployee);
        List<RiportLine> tempRiportline = new ArrayList<>();
        for (int i = 0; i < timeSheetItems.size(); i++) {
            if (timeSheetItems.get(i).getEmployee().equals(inputEmployee) &&
                    timeSheetItems.get(i).getBeginYear() == year &&
                    timeSheetItems.get(i).getBeginMonth() == month) {
                tempRiportline.add(riportLines.get(i));
            }
        }
        int sumOfHours = 0;
        int[] values = new int[projects.size()];
        for (int i = 0; i < projects.size(); i++) {
            for (int j = 0; j < tempRiportline.size(); j++) {
                if (projects.get(i).getName().equals(tempRiportline.get(j).getProject().getName())) {
                    sumOfHours = sumOfHours + (int) tempRiportline.get(j).getTime();
                    values[i] += (int) tempRiportline.get(j).getTime();
                }
            }
        }
        try(BufferedWriter writer = Files.newBufferedWriter(file)){
            writer.write(employeeName + "\t" + year + "-" + month + "\t" + sumOfHours +"\n");
            for (int i = 0; i < values.length; i++) {
                if (values[i] > 0){
                    writer.write(projects.get(i).getName() + "\t" + values[i] + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isItEvenOurWorker(Employee employee) {
        for (Employee currentEmployee : employees) {
            if (currentEmployee.equals(employee)) {
                return true;
            }
        }
        throw new IllegalArgumentException("Given employeeName is not our employee!");
    }
}