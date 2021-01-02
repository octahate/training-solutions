package week09d03;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Person {
    String name;
    int age;
    Present present;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent() {
        Random rnd = new Random();
        Present[] possiblePresents = Present.values();
        if (age > 14){
            this.present = possiblePresents[(rnd.nextInt(3)) +1];
        }
        else {
            this.present = possiblePresents[(rnd.nextInt(4))];
        }
    }
}
