package collectionsset.collectionstreeset;


import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings){
        Set<String> words = new TreeSet<>();
        words.addAll(Arrays.asList(randomStrings));
        return words;
    }


}
