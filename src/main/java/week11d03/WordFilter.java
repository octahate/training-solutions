package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    List<String> wordsWithChar(List<String> words, char c) {
        if (words == null || words.isEmpty()) {
            throw new NullPointerException("String list canot be empty!");
        }
        List<String> solution = new ArrayList<>();
        for (String word : words) {
            if (word.contains(Character.toString(c))) {
                solution.add(word);
            }
        } return solution;
    }
}
