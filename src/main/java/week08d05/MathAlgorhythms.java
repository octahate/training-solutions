package week08d05;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorhythms {

    public static int greatestCommonDivisor(int first, int second) {
        List<Integer> firtdivisors = new ArrayList<>();
        List<Integer> seconddivisors = new ArrayList<>();

        for (int i = first; i != 0; i--) {
            if (first % i == 0) {
                firtdivisors.add(i);
            }
        }
        for (int j = second; j != 0; j--) {
            if (second % j == 0) {
                seconddivisors.add(j);
            }
        }
        int solution = 1;
        if (firtdivisors.size() > seconddivisors.size()) {
            for (int m = 0; m < firtdivisors.size(); m++) {
                for (int n = 0; n < seconddivisors.size(); n++) {
                    if (firtdivisors.get(m).equals(seconddivisors.get(n))) {
                        return solution = firtdivisors.get(m);
                    }
                }
            }
        } else {
            for (int k = 0; k < seconddivisors.size(); k++) {
                for (int l = 0; l < firtdivisors.size(); l++) {
                    if (firtdivisors.get(l).equals(seconddivisors.get(k))) {
                        return solution = firtdivisors.get(l);
                    }
                }
            }
        }
        return solution;
    }
}