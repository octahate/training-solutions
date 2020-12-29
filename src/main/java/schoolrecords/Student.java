package schoolrecords;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks;
    private String name;

    public static boolean isEmpty(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        return false;
    }

    public Student(String name) {
        if (isEmpty(name) == false) {
            this.name = name;
            marks = new ArrayList<>();
        }
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        int sum = 0;
        int grades = 0;
        for (int i = 0; i < marks.size(); i++) {
            sum = sum + marks.get(i).getMarkType().getValue();
            grades++;
        }
        if (grades == 0 || marks.size() == 0) {
            return 0.0;
        }
        return Math.round(((double) sum / grades) * 100) / 100.0;
    }

    public double calculateSubjectAverage(Subject subject) {
        int sum = 0;
        int grades = 0;
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i).getSubject() == subject) {
                sum = sum + marks.get(i).getMarkType().getValue();
                grades++;
            }
        }
        if (grades == 0) {
            return 0.0;
        }
        return Math.round(((double) sum / grades) * 100) / 100.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" marks: ");
        for (int i = 0; i < marks.size(); i++) {
            sb.append(marks.get(i).getSubject().getSubjectName());
            sb.append(": ");
            sb.append(marks.get(i).getMarkType().getDescription());
            sb.append("(");
            sb.append(marks.get(i).getMarkType().getValue());
            sb.append(")");
        }
        return sb.toString();
    }
}


