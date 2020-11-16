package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<String> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<String> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(String Subject) {
        int count = 0;
        boolean value = false;
        do {
            value = Subject.equals(taughtSubjects.get(count));
            count ++;
        } while (value == true || count+1 == taughtSubjects.size());
        return value;
    }
}

