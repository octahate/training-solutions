package collectionslist.collectionsarraylist;

import java.util.List;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount){
        if (ballCount >= lotteryType){
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }

    }
}
