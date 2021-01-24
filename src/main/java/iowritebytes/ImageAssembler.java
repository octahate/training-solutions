package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] data, Path path) {
        Path file = path.resolve("image.png");
        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (byte[] currentbyte : data) {
                os.write(currentbyte);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file");
        }
    }
}

