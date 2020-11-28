package week05d05;

import introexeption.patient.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    User user = new User("kiss", "jános", "kjani@gmail.com");
    User user2 = new User("kiss", "jános", "kjanigmail.com");

    @Test
    public void userTestFirstname() {
        assertEquals(user.getFirstName(), "kiss");
    }

    @Test
    public void userTestLastname() {
        assertEquals(user.getLastName(), "jános");
    }

    @Test
    public void userTestemail() {
        assertEquals(user.getEmail(), "kjani@gmail.com");
    }

    @Test
    public void userTestFullname() {
        assertEquals(user.getFullName(), "kiss jános");
    }

    @Test
    public void wrongEmail() throws IllegalArgumentException {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Email missing \'@\' or \'.\'");
        });

    }
}
