package week12d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeRounderTest {


    GradeRounder gr = new GradeRounder();

    @Test
    public void TestRounding(){
        int[] numbers = new int[]{35, 40, 41, 46};
        int[] expectedSolution = new int[]{35, 40, 45, 50};
        assertEquals(expectedSolution,gr.roundGrades(numbers));
    }
}
