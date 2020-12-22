package defaultconstructor;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleDateTest {

    @Test
    public void testLeapYear() {
        SimpleDate simpleDate = new SimpleDate();
        assertThat(simpleDate.isLeapYear(1990), equalTo(false));
        assertThat(simpleDate.isLeapYear(2000), equalTo(true));
        assertThat(simpleDate.isLeapYear(1700), equalTo(false));
        assertThat(simpleDate.isLeapYear(1980), equalTo(true));
    }

    @Test
    public void testMonthLength(){
        SimpleDate simpleDate = new SimpleDate();
        assertThat(simpleDate.calculateMonthLength(2000,3), equalTo(31));
        assertThat(simpleDate.calculateMonthLength(2000,2), equalTo(29));
        assertThat(simpleDate.calculateMonthLength(2001,2), equalTo(28));
        assertThat(simpleDate.calculateMonthLength(2006,12), equalTo(31));
        assertThat(simpleDate.calculateMonthLength(2006,4), equalTo(30));
    }

    @Test
    public void testIsCorrect(){
        SimpleDate simpleDate = new SimpleDate();
        assertThat(simpleDate.isCorrect(1996,12,12), equalTo(true));
        assertThat(simpleDate.isCorrect(2000,2,29), equalTo(true));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            simpleDate.isCorrect(1914, 2, 29);
        });
        assertEquals("One or more given parameter cannot be applied! 1914, 2, 29", ex.getMessage());
    }
    @Test
    public void incorrectParameterShouldThrowExceptionNotALeapYear() throws IllegalArgumentException {
        SimpleDate sd = new SimpleDate();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            sd.setDate(1914, 2, 29);
        });

        assertEquals("One or more given parameter cannot be applied! 1914, 2, 29", ex.getMessage());
    }

    @Test
    public void incorrectParameterShouldThrowExceptionDayIncorrect() throws IllegalArgumentException {
        SimpleDate sd = new SimpleDate();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            sd.setDate(2000, 4, 31);
        });

        assertEquals("One or more given parameter cannot be applied! 2000, 4, 31", ex.getMessage());
    }

    @Test
    public void incorrectParameterShouldThrowExceptionYearIncorrect() throws IllegalArgumentException {
        SimpleDate sd = new SimpleDate();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            sd.setDate(1848, 3, 15);
        });

        assertEquals("One or more given parameter cannot be applied! 1848, 3, 15", ex.getMessage());
    }

    @Test
    public void incorrectParameterShouldThrowExceptionMonthIncorrect() throws IllegalArgumentException {
        SimpleDate sd = new SimpleDate();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            sd.setDate(2014, 13, 15);
        });

        assertEquals("One or more given parameter cannot be applied! 2014, 13, 15", ex.getMessage());
    }

    @Test
    public void testSetDate() {
        SimpleDate date = new SimpleDate();
        date.setDate(2016, 2, 29);
        assertEquals(2016, date.getYear());
        assertEquals(2, date.getMonth());
        assertEquals(29, date.getDay());
    }
}
