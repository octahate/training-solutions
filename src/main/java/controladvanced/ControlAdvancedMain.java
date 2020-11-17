package controladvanced;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlAdvancedMain {

    List<Integer> list = Arrays.asList(1, 4, 5, 6, 2, 4, 5, 6, 5);


    public String wordWithPrefix(List<String> words, String prefix) {
        String found = null;
        for (String word : words) {
            if (word.startsWith(prefix)) {
                found = word;
                break;
            }
        }
        return found;
    }

    public int numberOfPs(String s) {
        String words = "peter piper picked a ...";
        int numPs = 0;

        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) != 'p') {
                continue;
            }

            numPs++;
        }
        return numPs;
    }


    }

