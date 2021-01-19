package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private List<String> Ids = new ArrayList<>();


    public List<String> getIds() {
        return new ArrayList<>(Ids);
    }

    public void readIdsFromFile(String filename){
        Path file = Path.of("src/main/resources/idread/" + filename);
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
