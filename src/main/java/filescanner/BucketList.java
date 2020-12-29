package filescanner;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BucketList {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(Path.of("filescanner/bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());

            }
        } catch (IOException io) {
            throw new IllegalStateException("can't read file", io);
        }
    }
}

