package week08d03;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListTest {

    @Test
    public void StringListTest(){
        assertEquals(new ArrayList<>(Arrays.asList("szilva","alma","körte","szőlő","barack")),StringList.stringListUnion(new ArrayList<>(Arrays.asList("alma", "körte", "szőlő", "barack")), new ArrayList<>(Arrays.asList("alma", "szilva"))));
    }
}
