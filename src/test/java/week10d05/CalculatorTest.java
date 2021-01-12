package week10d05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calc = new Calculator();
    int[] myIntArray = {1, 2,3,4};

    @Test
    public void CalculatorSumTest() {
        assertEquals(10, calc.findMinSum(myIntArray));
    }
}
