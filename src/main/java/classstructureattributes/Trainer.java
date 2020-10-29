package classstructureattributes;

public class Trainer {
    String name;
    int yearOfBirth;
    public String getName() {
        return name;
    }
    public String getNameAndYearOfBirth () {
        return name + " " + yearOfBirth;
    }
    public void changeName(String newName){
    name = newName;
    }
}