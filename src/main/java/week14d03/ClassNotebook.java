package week14d03;

import java.util.*;

public class ClassNotebook {

    List<Student> students;

    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> sortNotebook(){
        List<Student> result = new ArrayList<>(students);
        Collections.sort(result);
        return result;
    }



    public static void main(String[] args) {
        ClassNotebook cn = new ClassNotebook(Arrays.asList(new Student("Peter"), new Student("Laci")));
        cn.students.get(0).newGrade("Történelem",1);
        System.out.println(cn.sortNotebook());
    }
}
