package week05d03;

import java.util.List;

public class ListCounter {

    public int CountAS (List<String> list) {
        int counter = 0;
        for (int i=0; i<list.size(); i++){
            if (list.get(i).charAt(0) == 'a' && list.get(i).charAt(0) == 'A'){
                counter++;
            }
        }
        return counter;
    }

}
