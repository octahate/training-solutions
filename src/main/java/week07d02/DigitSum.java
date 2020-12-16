package week07d02;

public class DigitSum {

    public int sumOfDigits (Integer numbers){
        String numbersText = numbers.toString();
        int finished = 0;
        for (int i = 0; i < numbersText.length(); i++) {
            finished = finished + numbersText.charAt(i) ;
        }
        return finished;
    }
}
