package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students;

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
        students = new ArrayList<>();
    }

    private boolean isEmpty(String text) {
        if (text.isBlank()) {
            return true;
        }
        return false;
    }

    public boolean addStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(student.getName())) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public double calculateClassAverage() {
        if (students.size()==0){
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sumOfAvg = 0.0;
        for (int i = 0; i < students.size(); i++) {
            sumOfAvg = sumOfAvg + students.get(i).calculateAverage();
        }
        if (sumOfAvg == 0.0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }

        return (sumOfAvg / (double) students.size() * 100) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (students.size()==0){
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sumOfAvg = 0.0;
        int whoHasIt = 0;
        for (int i = 0; i < students.size(); i++) {
            double studentAverage;
            studentAverage = students.get(i).calculateSubjectAverage(subject);
            if (studentAverage != 0){
                sumOfAvg = sumOfAvg + studentAverage;
                whoHasIt++;
            }
            if (whoHasIt == 0){
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
        }
        return Math.round(100 * sumOfAvg / whoHasIt ) / 100.0;
    }

    public Student findStudentByName(String name) {

        if (name == null ||name.isBlank()){
            throw new IllegalArgumentException("Student name must not be empty!");
        }

        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name))
                return students.get(i);
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public Student repetition() {
        if (students.size() == 0){
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studentsNew = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            studentsNew.add(new StudyResultByName(students.get(i).getName(), students.get(i).calculateAverage()));
        }
        return studentsNew;
    }

    public String listStudentNames() {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            names.append(students.get(i).getName());
            names.append(",");
            names.append(" ");
        }
        names.deleteCharAt(names.toString().length()-2);
        names.deleteCharAt(names.toString().length()-1);
        return names.toString();
    }

    public String getClassName() {
        return className;
    }
}
