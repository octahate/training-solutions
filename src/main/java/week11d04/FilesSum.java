package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int sumNumbers(){
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            String first = "number" + (i < 10 ? "0" : "") + i;
            if (Files.isRegularFile(Path.of(first))){
                try {
                    String content = Files.readString(Path.of(first));
                    sum += Integer.parseInt(content);
                } catch (IOException e) {
                    throw new IllegalStateException("Can not read", e);
                }
            }
        }
        return sum;
    }
}
