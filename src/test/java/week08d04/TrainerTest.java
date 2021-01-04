package week08d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    Trainer goodMoodTrainer = new Trainer(new GoodMood());
    Trainer badMoodTrainer = new Trainer(new BadMood());

    @Test
    public void getGoodMoodGrade() {
        assertEquals(5, goodMoodTrainer.giveMark());
        assertEquals(3, badMoodTrainer.giveMark());
    }
}
