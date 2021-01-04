package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathAlgorithmTest {
    @Test
    public void testGreatestCommonDivisor(){
        assertEquals(2,MathAlgorhythms.greatestCommonDivisor(6,4));
        assertEquals(4,MathAlgorhythms.greatestCommonDivisor(8,4));
        assertEquals(4,MathAlgorhythms.greatestCommonDivisor(4,8));
        assertEquals(3,MathAlgorhythms.greatestCommonDivisor(12,3));
        assertEquals(1,MathAlgorhythms.greatestCommonDivisor(20,31));
    }
}
