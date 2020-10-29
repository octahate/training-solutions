package classstructuremethods;

public class Trainer {
    private String name;
    private int yearOfBirth;
    public String getName() {
        return name;
    }
    public int getAge(int year){
        return year - yearOfBirth;
    }
    public String getNameAndYearOfBirth () {
        return name + ": " + yearOfBirth;
    }
    public void changeName(String name){
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
