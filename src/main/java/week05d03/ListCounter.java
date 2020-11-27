package week05d03;

import java.util.List;

public class ListCounter {

    public int CountAS (List<String> list) {
        int counter = 0;
        for (int i=0; i<list.size(); i++){
            if (list.get(i).charAt(0) == 'a' || list.get(i).charAt(0) == 'A'){
                counter++;
            }
        }
        return counter;
    }
    public int CountASBetter (List<String> words) {
        int count = 0;
        String first = "";

        for (String word: words) {
            first = word.substring(0, 1).toUpperCase();
            if ("A".equals(first)){
                count=count + 1;
            }
        }
        return count;
    }
}
