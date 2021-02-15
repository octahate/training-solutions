package exampractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VowelFilter {

    public String filteredVowel(BufferedReader reader) throws IOException {
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            result.append(returnStringWithoutVowels(line));
            result.append('\n');
        }
        return result.toString();
    }

    private String returnStringWithoutVowels(String line) {
        StringBuilder currentWord = new StringBuilder();
        for (char currentChar : line.toCharArray()) {
            if (!isVowel(currentChar)) {
                currentWord.append(currentChar);
            }
        }
        return currentWord.toString();
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'A'
                || letter == 'á' || letter == 'Á'
                || letter == 'e' || letter == 'E'
                || letter == 'é' || letter == 'É'
                || letter == 'i' || letter == 'í'
                || letter == 'o' || letter == 'O'
                || letter == 'ó' || letter == 'Ó'
                || letter == 'ö' || letter == 'Ö'
                || letter == 'ő' || letter == 'Ő'
                || letter == 'u' || letter == 'U'
                || letter == 'ú' || letter == 'Ú'
                || letter == 'ü' || letter == 'Ü'
                || letter == 'ű' || letter == 'Ű';
    }


    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/java/exampractice/words.txt"))) {
            System.out.println(new VowelFilter().filteredVowel(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}

