package covid;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    Validator v = new Validator();

    @Test
    public void isNameValidTest(){
        assertEquals("Kovács Péter",v.isNameValid("Kovács Péter"));
    }

    @Test
    public void isZipValidTest(){
        assertEquals("4033", v.isZipValid("4033"));
    }

    @Test
    public void isEmailValidTest(){
        assertEquals("g@g.com",v.isEmailValid("g@g.com"));
    }

    @Test
    public void isAgeValidTest(){
        assertEquals("20", v.isAgeValid("20"));
    }

    @Test
    public void isSSNValidTest(){
        assertEquals("123461690", v.isSNNValid("123461690"));
    }

}
