package week08d02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lottery {

    private Random rnd;
    private StringBuilder numberstext;
    private List<Integer> numbersList;

    public Lottery() {
        rnd = new Random();
        numberstext = new StringBuilder();
        numbersList = new ArrayList<>();
        getNumbers();
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }

    public String getNumbers() {
        while (numbersList.size() < 5) {
            int newNumber = rnd.nextInt(91) + 1;
            if (!numbersList.contains(newNumber)) {
                numbersList.add(newNumber);
                numberstext.append(newNumber);
                numberstext.append(", ");
            }
        }
        return numberstext.toString();
    }

}
