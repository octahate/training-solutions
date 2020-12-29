package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> taughtSubjects;

    public String getName() {
        return name;
    }

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (int i = 0; i < taughtSubjects.size(); i++) {
            if (subject.getSubjectName().equals(taughtSubjects.get(i).getSubjectName())){
                return true;
            }
        }
        return false;
    }
}


