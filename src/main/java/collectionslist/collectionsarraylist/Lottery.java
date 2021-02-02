package collectionslist.collectionsarraylist;

import java.util.*;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount){
        if (ballCount <= lotteryType){
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        Random rnd = new Random();
        List<Integer> results = new ArrayList<>();
        while (results.size() != lotteryType){
            int nextNumber = rnd.nextInt(ballCount+1);
            if (!results.contains(nextNumber)){
                results.add(nextNumber);
            }
        }
        Collections.sort(results);
        return results;
    }
}
