package week12d03;

import java.util.Collections;
import java.util.List;

public class NumberStat {


    public int onlyOnce(List<Integer> numbers){
        if (numbers.size() < 1 ){
            throw new IllegalArgumentException("List must be longer than" + numbers.size() + "!");
        }
        Collections.sort(numbers);
        int currentValue = numbers.get(0);
        int currentCounter = 0;
        int nextCounter = 0;

        for (int currentNumber: numbers){
            if (currentValue == currentNumber) {
                currentCounter++;
            }
        }
        return 0;
    }

}
