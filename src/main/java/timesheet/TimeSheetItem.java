package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;

public final class TimeSheetItem {
    private Employee employee;
    private Project project;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    public double hoursBetweenDates() {
        return Duration.between(beginDate, endDate).toHours();
    }

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        this.employee = employee;
        this.project = project;
        if (beginDate.toLocalDate().equals(endDate.toLocalDate()) && !beginDate.isAfter(endDate)) {
            this.beginDate = beginDate;
            this.endDate = endDate;
        } else throw new IllegalArgumentException("End date cannot be later than start date!");
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public int getBeginYear() {
        return beginDate.getYear();
    }

    public int getBeginMonth() {
        return beginDate.getMonthValue();
    }

}

