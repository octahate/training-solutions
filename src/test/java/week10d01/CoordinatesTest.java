package week10d01;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinatesTest {

    @Test
    public void CoordinatesTest(){
        assertEquals(20, new Coordinates(20,10,5).getxCoordinate());
        assertEquals(10, new Coordinates(20,10,5).getyCoordinate());
        assertEquals(5, new Coordinates(20,10,5).getzCoordinate());
    }
}
