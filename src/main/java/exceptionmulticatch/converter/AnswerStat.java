package exceptionmulticatch.converter;

import java.util.Arrays;

public class AnswerStat {


    BinaryStringConverter bsc;

    public AnswerStat(BinaryStringConverter bsc) {
        this.bsc = bsc;
    }

    public boolean[] convert(String input) {
        try {
            return bsc.binaryStringToBooleanArray(input);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException(ex);
        }
    }

    int answerTruePercent(String answers) {
        boolean[] answerArray = Arrays.copyOf(convert(answers), answers.length());
        int amountOfTrues = 0;
        int size = answers.length();
        for (boolean singleStat : answerArray) {
            if (singleStat) {
                amountOfTrues++;
            }
        }
        double solution = (double) amountOfTrues / size * 100;
        return (int) solution;
    }
}
