package stringbasic.pets;

import java.time.LocalDate;
import java.util.Date;

public class Pet {
    private String name;
    private LocalDate date;
    private Gender gender;
    private String regnum;

    public Pet(String name, LocalDate date, Gender gender, String regnum) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.regnum = regnum;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegnum() {
        return regnum;
    }
}
