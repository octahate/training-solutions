package week10d01;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class HikingTest {

    Hiking testHiking = new Hiking(Arrays.asList(
            new Coordinates(47,3,10),
            new Coordinates(47,3,20),
            new Coordinates(47,3,15),
            new Coordinates(47,3,18)));

    @Test
    public void testCoordinates(){
        assertEquals(10, testHiking.getHeights().get(0));
    }

    @Test
    public void testGetPlusElevation(){
        assertEquals(13, testHiking.getPlusElevation());
    }

    @Test
    public void testGetPlusElevationFromList(){
        assertEquals(13, Hiking.getPlusElevation(Arrays.asList((float)10.0,(float)20.0,(float)15.0,(float)18.0)));
    }
}
