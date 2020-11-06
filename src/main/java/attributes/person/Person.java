package attributes.person;

public class Person {
    private String name;
    private String identificationCard;

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public String personToString(){
        String full;
        full = name + " " + identificationCard;
        return full;
    }



}
