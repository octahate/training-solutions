package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public String createHistogram(BufferedReader reader) throws IOException {
        String line;
        StringBuilder asterisksLine = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            asterisksLine.append(turnLineToAsterisks(line));
        }
        return asterisksLine.toString();
    }

    private String turnLineToAsterisks(String input) {
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(input); i++) {
            asterisks.append("*");
        }
        asterisks.append("\n");
        return asterisks.toString();
    }
}

