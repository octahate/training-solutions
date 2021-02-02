package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {


    private List<Integer> makeBallPool (int maxNumber){
        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public Set<Integer> selectWinningNumbers(int drawCount, int maxNumber){
        if (maxNumber <= drawCount){
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        return new TreeSet<>(makeBallPool(maxNumber));
    }
}
