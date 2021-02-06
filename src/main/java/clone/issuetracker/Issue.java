package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comment;

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public Issue(String name, LocalDateTime time, Status status, List<Comment> comment) {
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
            this.comment = new ArrayList<>();
        }
    }

}
