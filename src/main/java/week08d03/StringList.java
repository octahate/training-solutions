package week08d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringList {

    public static List<String> stringListUnion(List<String> first, List<String> second) {
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                if (first.get(i).equals(second.get(j))){
                    second.remove(j);
                }
            }
        }
        second.addAll(first);
        return second;
    }

    public static void main(String[] args) {
        System.out.println(stringListUnion(new ArrayList<>(Arrays.asList("alma", "körte", "szőlő")), new ArrayList<>(Arrays.asList("alma", "eper", "szőlő", "körte"))).toString());
    }
}


