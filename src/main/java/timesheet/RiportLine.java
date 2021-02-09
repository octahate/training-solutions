package timesheet;

public class RiportLine {

    private Project project;
    private long time;

    public RiportLine(Project project, long time) {
        this.project = project;
        this.time = time;
    }

    public Project getProject() {
        return project;
    }

    public long getTime() {
        return time;
    }

    public void addTime(long time){
        this.time += time;
    }
}
