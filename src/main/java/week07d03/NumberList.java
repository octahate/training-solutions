package week07d03;

import java.util.Arrays;
import java.util.List;

public class NumberList {
    public boolean isIncreasing(List<Integer> numbers) {
        boolean isTrue = true;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i - 1)) {
                isTrue = false;
                return isTrue;
            }
        }
        return isTrue;
    }


    public static void main(String[] args) {
        NumberList numlist = new NumberList();
        System.out.println(numlist.isIncreasing(Arrays.asList(1,2,2,3)));
        System.out.println(numlist.isIncreasing(Arrays.asList(3,2,2,3)));

    }
}