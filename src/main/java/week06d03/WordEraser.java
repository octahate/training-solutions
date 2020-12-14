package week06d03;

import java.util.ArrayList;
import java.util.List;



public class WordEraser {
    public String eraseWord(String words, String word){
        List<String> all = new ArrayList<>();
        int first = 0;
        int last;
        for (int i = 0; i < words.length(); i++){
            if (" ".equals(words.charAt(i))){
                last = words.charAt(i)-1;
                all.add(words.substring(first,last));
                last = first;
            }
        }
        for (int j = 0; j < all.size(); j++){
            if (word.equals(all.get(j))) {
                all.remove(j);
            }
        }
        return all.toString();
    }
}
