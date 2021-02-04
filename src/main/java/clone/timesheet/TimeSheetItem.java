package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public TimeSheetItem(TimeSheetItem item) {
        employee = item.getEmployee();
        project = item.getProject();
        from =item.getFrom();
        to = item.getTo();
    }

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem withDifferentDay(TimeSheetItem current, LocalDate date){
        TimeSheetItem newTimeSheetItem = new TimeSheetItem(current);
        newTimeSheetItem.from = LocalDateTime.of(date, newTimeSheetItem.from.toLocalTime());
        newTimeSheetItem.to = LocalDateTime.of(date, newTimeSheetItem.to.toLocalTime());
        return current;
    }
}
