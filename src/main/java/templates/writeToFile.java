package templates;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Watchable;

public class writeToFile {

    public void writeToFile(String file) {
        Path path = Path.of(file);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path))) {
            writer.println("text");
            writer.print(22);
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file!", e);
        }
    }
}
