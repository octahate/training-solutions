package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) // felvesz egy diákot az osztályba
    public boolean removeStudent(Student student) //kivesz egy diákot az osztályból
    public double calculateClassAverage() //osztályátlagot számol, minden diákot figyelembe véve
    public double calculateClassAverageBySubject(Subject subject) //tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
    public Student findStudentByName(String name) // név szerint megkeres egy diákot az osztályban
    public Student repetition() //felelethez a listából random módon kiválaszt egy diákot
    public List<StudyResultByName> listStudyResults() //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza
    public String listStudentNames() //kilistázza a diákok neveit, vesszővel elválasztva
}
