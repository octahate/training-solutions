import introjunit.Gentleman;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {
    @Test
    public void test() {
        //Given
        Gentleman gentleman = new Gentleman();

        //When
        String salute = gentleman.sayHello("Dodie");

        //Then
        assertThat(salute, equalTo("Hello Dodie"));
    }
    @Test
    public void test2(){
        assertThat (new Gentleman().sayHello(null), equalTo("Hello Anonymus!"));
    }
}
