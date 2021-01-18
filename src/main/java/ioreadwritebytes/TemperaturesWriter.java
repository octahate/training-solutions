package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String pathString){
        Path location = Path.of(pathString);
        try {
            Files.write(location,temperatures.getData());
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file!", e);
        }
    }
}
