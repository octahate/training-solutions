package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String input) {
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
                    throw new IllegalArgumentException("Input String invalid!");
            }
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] input) {
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

