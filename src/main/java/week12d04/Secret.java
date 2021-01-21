package week12d04;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Secret {

    public void printSecret(Path path) {

        try {
            byte[] bytes = Files.readAllBytes(path);
            for (byte b : bytes) {
                char c = (char) (b + 10);
                System.out.print(c);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file!");
        }

    }


    public static void main(String[] args) {
        Path file = Path.of("src/main/java/week12d04/secret.dat");
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))) {
            byte[] bytes = new byte[1000];
            int size = inputStream.read(bytes);
            char[] text = new char[size];
            for (int i = 0; i < text.length; i++) {
                text[i] = (char) ((char) bytes[i] + 10);
            }
            System.out.println(Arrays.toString(text));
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        Secret secret = new Secret();
        secret.printSecret(file);
    }
}
