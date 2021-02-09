package templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class readFromFile {

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }
    }

    public void readFromString(String name) {
        Path path = Path.of(name);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }
    }



    public static void main(String[] args) {
        readFromFile rff = new readFromFile();
        rff.readFromFile(Path.of("src/main/resources/employees.txt"));
        rff.readFromString("src/main/resources/employees.txt");
    }
}
