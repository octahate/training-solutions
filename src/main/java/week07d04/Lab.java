package week07d04;


import java.time.LocalDateTime;

public class Lab {
    private String title;
    private boolean completed;
    private LocalDateTime completedAt;

    public Lab(String title) {
        this.title = title;
        completed = false;
        completedAt = null;
    }

    public Lab(String title, LocalDateTime completedAt) {
        this.title = title;
        this.completedAt = completedAt;
        completed = true;
    }

    public void complete(LocalDateTime time) {
        completedAt = time;
        completed = true;
    }

    public void complete() {
        completedAt = LocalDateTime.now();
        completed = true;
    }

    @Override
    public String toString() {
        return "A feladat címe:" + title + '\'' +
                "be lett fejezve?:" + completed +
                "mikor?" + completedAt;
    }
}