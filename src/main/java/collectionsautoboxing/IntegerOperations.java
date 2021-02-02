package collectionsautoboxing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers){
        List<Integer> solution = new ArrayList<>();
        for (Integer currentNumber : numbers){
            solution.add(currentNumber);
        }
        return solution;
    }

    public int sumIntegerList(List<Integer> integerList){
        int sum = 0;
        for (int currentInteger : integerList){
            sum += currentInteger;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers){
        int sum = 0;
        for (Integer currentInteger : integers){
            sum += currentInteger;
        }
        return sum;
    }
}

