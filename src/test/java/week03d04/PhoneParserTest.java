package week03d04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class PhoneParserTest {

    PhoneParser pp = new PhoneParser();
    Phone ph = new Phone("10","1234567");

    @Test
    public void testParser(){
        assertEquals(ph, pp.parse("10-1234567"));
    }

    @Test
    public void throwException(){
        assertThrows(IllegalArgumentException.class, () -> pp.parse("1111"));
    }
}
