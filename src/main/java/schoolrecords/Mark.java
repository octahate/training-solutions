package schoolrecords;

public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        this.subject = subject;
        this.tutor = tutor;
        // markType =  //
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markType=" + markType +
                ", subject=" + subject +
                ", tutor=" + tutor +
                '}';
    }
}
