package iowriter.names;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NamesWriter {

    private Path file;

    public NamesWriter(Path file) {
        this.file = file;

    }

    public void addAndWrite(String name){
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(file)){
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file!",e);
        }
    }
}
