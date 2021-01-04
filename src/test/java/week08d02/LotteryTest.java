package week08d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LotteryTest {

    Lottery lotto = new Lottery();

    @Test
    public void areThereFiveNumbers(){
        assertEquals(5,new Lottery().getNumbersList().size());
    }

    @Test
    public void areThereDuplicates(){
        assertFalse(lotto.getNumbersList().get(0) == (lotto.getNumbersList().get(1)));
        assertFalse(lotto.getNumbersList().get(0) == (lotto.getNumbersList().get(1)));
        assertFalse(lotto.getNumbersList().get(0) == (lotto.getNumbersList().get(2)));
        assertFalse(lotto.getNumbersList().get(0) == (lotto.getNumbersList().get(3)));
        assertFalse(lotto.getNumbersList().get(0) == (lotto.getNumbersList().get(4)));
    }
}
