package week04;

import java.util.ArrayList;
import java.util.List;

public class Search {
        public List<Integer> getIndexesOfChar(String str, char c) {
            List<Integer> result = new ArrayList<>();
            for (int i=0; i< str.length(); i++)
                 if (c == str.charAt(i)){
                result.add(str.indexOf(c));
            }
                return result;
        }
    }
}
