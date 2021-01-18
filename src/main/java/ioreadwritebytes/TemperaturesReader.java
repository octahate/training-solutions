package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String path){
        byte[] bytes;
        Path file = Path.of("path");
        try {
            bytes = Files.readAllBytes(file);
        } catch (IOException e) {
            throw new IllegalStateException("Can't reach file!");
        }
       Temperatures solution = new Temperatures(bytes);
        return solution;
    }
}
