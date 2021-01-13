package week11d01;

public class DivisorFinder {
    int findDivisors(int n){
        String numbersOfn = Integer.toString(n);
        int amountOfDivisors = 0;
        for (int i = 0; i < numbersOfn.length(); i++) {
            if (n % Integer.parseInt(numbersOfn.substring(i, i+1)) == 0){
                amountOfDivisors++;
            }
        } return amountOfDivisors;
    }
}
