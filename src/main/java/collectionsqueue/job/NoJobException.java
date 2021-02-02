package collectionsqueue.job;

public class NoJobException extends Exception {

    private final String message;

    public NoJobException(String message1) {
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
