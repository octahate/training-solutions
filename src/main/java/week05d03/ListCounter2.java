package week05d03;

import java.util.List;

public class ListCounter2 {
    public static int isA(List<String> words) {
        int amount = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).startsWith("a") && words.get(i).startsWith("A")) {
                amount++;
            }
        }
        return amount;
    }
}
