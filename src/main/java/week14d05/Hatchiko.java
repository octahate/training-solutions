package week14d05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hatchiko {


    public String countWords(String subtitle, String... words) {
        Path path = Path.of(subtitle);
        StringBuilder sb = new StringBuilder();
        int[] wordCounter = new int[words.length];
        try (BufferedReader read = Files.newBufferedReader(path)) {
            while (read.readLine() != null) {
                String current = read.readLine();
                for (int i = 0; i < words.length; i++) {
                    if (current.contains(words[i])) {
                        wordCounter[i]++;
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File cannot be read");
        }
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            sb.append(":");
            sb.append(wordCounter[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
