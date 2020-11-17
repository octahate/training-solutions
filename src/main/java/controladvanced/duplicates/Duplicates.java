package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public List<Integer> find(List<Integer> input) {
        List<Integer> duplicate = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (input.get(i).equals(input.get(j))) {
                    duplicate.add(input.get(j));
                    break;

                }

            }

        }
        return duplicate;
    }

    public static void main(String[] args) {

    }
}
