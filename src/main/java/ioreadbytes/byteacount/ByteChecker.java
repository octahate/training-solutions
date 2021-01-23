package ioreadbytes.byteacount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {
    public static void main(String[] args) {

        Path file = Path.of("src/main/resources/ioreadbytes/data.dat");
        try (InputStream inputStream = Files.newInputStream(file)) {
            int count = 0;
            byte[] bytes = inputStream.readAllBytes();
            for (Byte currentByte: bytes){
                if (currentByte.equals((byte) 'a')){
                    count++;
                }
            }
            System.out.println(count);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }
}