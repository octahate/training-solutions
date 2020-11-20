package week04;

import java.util.ArrayList;
import java.util.List;

public class Search {
        public List<Integer> getIndexesOfChar(String str, char c) {
            List<Integer> result = new ArrayList<>();
            for (int i=0; i< str.length(); i++)
                str.charAt(i) = temp;
            if (c == temp) {
                result.add(str.indexOf(c));
            }
                return result;
        }
    }
}
