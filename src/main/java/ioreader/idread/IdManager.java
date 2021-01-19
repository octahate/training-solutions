package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    List<String> Ids = new ArrayList<>();

    public IdManager() {
    }

    public List<String> getIds() {
        return Ids;
    }

    public void readIdsFromFile(String filename){
        Path file = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null){
                Ids.add(nextLine);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file!", e);
        }
    }
}
