package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisorFinderTest {
    DivisorFinder df = new DivisorFinder();
    @Test
    public void findDivisorsTest(){
        assertEquals(1,df.findDivisors(425));
        assertEquals(0,df.findDivisors(79));
    }
}
