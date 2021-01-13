package week11d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFilterTest {
    WordFilter wf = new WordFilter();
    @Test
    public void TestWord(){
        assertEquals(List.of("cékla"),wf.wordsWithChar(List.of("cékla","retek"),'c'));
    }
}
