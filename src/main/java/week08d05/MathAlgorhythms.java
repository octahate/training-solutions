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
            if (first % j == 0) {
                seconddivisors.add(j);
            }
        }
       int solution = 1;
       if (firtdivisors.size() > seconddivisors.size()){
           for (int i = 0; i < firtdivisors.size(); i++) {
               for (int j = 0; j < seconddivisors.size(); j++) {
                   if (firtdivisors.get(i).equals(seconddivisors.get(j))){
                       return solution = firtdivisors.get(i);
                   }
               }
           }
       }
       else {
            for (int k = 0; k < seconddivisors.size(); k++) {
                for (int l = 0; l < firtdivisors.size(); l++) {
                    if (firtdivisors.get(k).equals(seconddivisors.get(l))){
                        return solution = firtdivisors.get(l);
                    }
                }
            }
        }
       return solution;
    }


    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(8,4));
        System.out.println(greatestCommonDivisor(6,3));
        System.out.println(greatestCommonDivisor(10,11));
        System.out.println(greatestCommonDivisor(1,1));

    }
}
