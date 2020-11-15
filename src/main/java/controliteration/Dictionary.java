package controliteration;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List <DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String word, List<String> translations){
        if (dictionaryItems.contains(word)) {
        } else { dictionaryItems.add(new DictionaryItem(word,translations));
        }
    }
}
