package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    Path myFile;
    List<Human> importedHumans = new ArrayList<>();

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return importedHumans;
    }

    public FileManager(String place) {
        this.myFile = Path.of(place);
    }


    public void readFromFile() {
        try {
            List<String> importedNames = Files.readAllLines(myFile);
            for(String currentName: importedNames){
                importedHumans.add(new Human(currentName.substring(0,currentName.indexOf(' ')),currentName.substring(currentName.indexOf(' ')+1)));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }

    }
}
