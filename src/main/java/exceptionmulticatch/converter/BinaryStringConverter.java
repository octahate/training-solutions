package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String input) {
        if (input == null)
            throw new NullPointerException("binaryString null");
        boolean[] result = new boolean[input.length()];
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '1':
                    result[i] = true;
                    break;
                case '0':
                    result[i] = false;
                    break;
                default:
                    throw new IllegalArgumentException("binaryString not valid");
            }
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] input) {
        if (input == null)
            throw new NullPointerException("booleans null");
        StringBuilder result = new StringBuilder();
        if (input.length == 0) {
            throw new IllegalArgumentException("Input Array invalid!");
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i]) {
                result.append('1');
            } else if (!(input[i])) {
                result.append('0');
            }
        }
        return result.toString();
    }

}

