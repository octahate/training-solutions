package wek06d01;

import org.junit.jupiter.api.Test;
import week06d01.ListSelector;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class ListSelectorTest {

    ListSelector listSelector = new ListSelector();

    @Test
    public void testError(){
        assertEquals("[almabarack]", listSelector.retu(Arrays.asList("alma","körte","barack")));
    }
    @Test
    public void testEmpty(){
        assertEquals("", listSelector.retu(Arrays.asList("")));
    }

}
