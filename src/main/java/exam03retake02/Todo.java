package exam03retake02;

public class Todo implements Comparable<Todo> {
    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        if (priority < 1 || priority > 5){
            throw new IllegalArgumentException("Invalid");
        }
        this.priority = priority;
        this.text = text;
        state = State.NON_COMPLETED;
    }

    public void complete(){
        state = State.COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public int compareTo(Todo o) {
        if (o.getPriority() > priority){
            return -1;
        }
        else return 1;
    }
}
