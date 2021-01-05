package week10d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxTravelTest {
    @Test
    public void MaxTravelWorks() {
        assertEquals(3, MaxTravel.getMaxIndex(Arrays.asList(2, 2, 1, 3, 3, 3)));
        assertEquals(6, MaxTravel.getMaxIndex(Arrays.asList(2, 2, 1, 3, 3, 3, 6, 6, 6, 6, 6)));
        assertEquals(6, MaxTravel.getMaxIndex(Arrays.asList(2, 2, 1, 3, 3, 3, 6, 6, 6, 6, 6, 4, 4)));
    }

    @Test
    public void testIllegalList() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MaxTravel.getMaxIndex(Arrays.asList(1, 1, 1, 1, 31)));
        assertEquals("Stop list is invalid!", ex.getMessage());
    }
}
