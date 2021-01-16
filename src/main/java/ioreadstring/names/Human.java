package ioreadstring.names;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String secondName) {
        this.firstName = firstName;
        this.lastName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
