package introexception.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("Year must be greater than 1900!");
        }
        if (new SsnValidator().isValidSsn(socialSecurityNumber) == false){
            throw new IllegalArgumentException("TAJ szám nem korrekt!");
        }
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
