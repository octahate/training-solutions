package week08d01;

import methoverloading.pub.ListOfGoodPubs;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    Robot robot= new Robot();

    @Test
    public void testLegalMove(){
        assertTrue(robot.isItLegalMove('L'));
        assertTrue(robot.isItLegalMove('F'));
    }

    @Test
    public void testIllegalMove(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> robot.isItLegalMove('S'));
        assertEquals("Illegal movement!", ex.getMessage());
    }

    @Test
    public void testRobotMovement(){

        assertEquals("Robot position:x=0, y=0",robot.move("FFLL"));
        robot.reset();
        assertEquals("Robot position:x=0, y=1",robot.move("FFFLL"));
        robot.reset();
        assertEquals("Robot position:x=1, y=1",robot.move("FFFLLJ"));
    }
}
