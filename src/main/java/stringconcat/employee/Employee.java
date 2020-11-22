package stringconcat.employee;

public class Employee {
    private String name;
    private String job;
    private long salary;

    public Employee(String name, String job, long salary) {
        if (salary % 1000 != 0){
            throw new IllegalArgumentException("Salary must be dividable by 1000");
        }

        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }

        if (name == null || name.equals("")){
            throw new IllegalArgumentException("Name must not be empty.");
            }

        if (job == null || job.equals("")) {
            throw new IllegalArgumentException("Job must not be empty.");
        }

        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }
}
