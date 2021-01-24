package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeAsBytes(List<String> text, Path path){
        try(OutputStream os = new BufferedOutputStream(Files.newOutputStream(path))){
            for (int i = 0; i < text.size(); i++) {
                if (text.get(i).charAt(0) != '_'){
                    os.write(text.get(i).getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e){
            throw new IllegalStateException("can't read file", e);
        }
    }
}
