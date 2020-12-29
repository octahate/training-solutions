package stringscanner;

import java.util.Scanner;

public class StringScanner {

    private static boolean isEmptyHere(String text) {
        if (text.isEmpty() || text.isBlank()) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        return false;
    }

    public int readAndSumValues(String intString, String delimiter) {
        Scanner scanner = new Scanner(intString);
        scanner.useDelimiter(delimiter);
        int sum = 0;
        if (isEmptyHere(intString) || isEmptyHere(delimiter) == false ) {
            while (scanner.hasNextInt()) {
                sum = sum + scanner.nextInt();
            }
        }
        return sum;
    }

    public int readAndSumValues(String intString) {
        Scanner scanner = new Scanner(intString);
        int sum = 0;
        if (isEmptyHere(intString) == false) {
            while (scanner.hasNextInt()) {
                sum = sum + scanner.nextInt();
            }
        }
        return sum;
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmptyHere(text) || word == null || "".equals(word)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        try (Scanner sc = new Scanner(text)) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains(word)) {
                    sb.append(line);
                    sb.append("\n");
                }
            }
            return sb.toString().trim();
        }
    }


}
