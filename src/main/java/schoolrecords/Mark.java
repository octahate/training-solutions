package schoolrecords;

public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    private static void isItNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Both subject and tutor must be provided!");
        }
    }

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
        isItNull(subject);
        isItNull(tutor);
        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        isItNull(subject);
        isItNull(tutor);
        this.markType = MarkType.valueOf(markType);
        this.subject = subject;
        this.tutor = tutor;
    }


    @Override
    public String toString() {
        return markType.getDescription() + "(" + markType.getValue() + ")";
    }
}
