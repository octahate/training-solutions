package week12d04;

import java.io.*;
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

    public void printSecrwtWithImputStream(Path path, Path destination) {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = Files.newInputStream(path);
             BufferedWriter os = Files.newBufferedWriter(destination)) {
            byte[] buffer = new byte[10];
            int size;
            while ((size = is.read(buffer)) > 0) {
                System.out.println(size);
                for (int i = 0; i < size; i++) {
                    char c = (char) (buffer[i] + 10);
                    os.write(Character.toString(c));
                }
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Path file = Path.of("src/main/java/week12d04/secret.dat");
        Path destination = Path.of("src/main/java/week12d04/output.txt");
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))) {
            byte[] bytes = new byte[10];
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
        secret.printSecrwtWithImputStream(file,destination);
    }
}
