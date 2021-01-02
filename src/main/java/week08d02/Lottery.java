package week08d02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lottery {


    public static String getNumbers() {
        Random rnd = new Random();
        StringBuilder numberstext = new StringBuilder();
        int[] numbers = rnd.ints(5, 1, 91).toArray();
        for (int i = 0; i < numbers.length; i++) {
            numberstext.append(numbers[i]);
            numberstext.append(", ");
        }
        return numberstext.toString();
    }

    public static void main(String[] args) {
        System.out.println(getNumbers());
    }
}
