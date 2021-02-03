package week14d03;

import java.util.*;

public class Student implements Comparable {

    private String studentName;
    private Map<String, List<Integer>> grades = new HashMap<>();

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public void newGrade(String subject, int grade){
        if (!grades.containsKey(subject)){
            grades.put(subject, new ArrayList<>());
        }
        grades.get(subject).add(grade);
    }

    public String getStudentName() {
        return studentName;
    }

    public Map<String, List<Integer>> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", grades=" + grades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
