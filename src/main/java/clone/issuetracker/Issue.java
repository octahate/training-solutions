package clone.issuetracker;

import java.time.LocalDateTime;

public class Issue {

    private String name;
    private LocalDateTime time;
    private Status status;
    private Comment comment;

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public Comment getComment() {
        return comment;
    }

    public Issue(String name, LocalDateTime time, Status status, Comment comment) {
        this.name = name;
        this.time = time;
        this.status = status;
        this.comment = comment;
    }

    public Issue (Issue newIssue, CopyMode howToCopy){
        this.name = newIssue.getName();
        this.time =newIssue.getTime();
        this.status = newIssue.getStatus();
        if (howToCopy == CopyMode.WITH_COMMENTS){
            this.comment = newIssue.getComment();
        }
        else {
            this.comment = new Comment("",LocalDateTime.now());
        }
    }

}
