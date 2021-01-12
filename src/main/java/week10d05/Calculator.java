package week10d05;

import static java.util.Arrays.sort;

public class Calculator {
    public int findMinSum(int[] arr){
        if ( arr == null || arr.length < 4){
            throw new IllegalArgumentException("List must be at least 4 in size!");
        }
        sort(arr);
        return arr[0] + arr [1] + arr [2] + arr [3];
    }
}
