package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {
    ListCounter lc = new ListCounter();

    @Test
   public void testListapples() {
        List<String> testList = Arrays.asList("Alma", "körte", "szilva","alma");
        assertEquals(2, lc.CountAS(testList));
    }

    @Test
    public void testEmptyList() {
        List<String> testList = Arrays.asList();
        assertEquals(0, lc.CountAS(testList));
    }
    @Test
    public void testAless() {
        List<String> testList = Arrays.asList("Sajt", "kenyér", "hús");
        assertEquals(0, lc.CountAS(testList));
    }
}