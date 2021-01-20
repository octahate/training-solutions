package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {
    public List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String currentName : names) {
                if (currentName.contains("Dr")) {
                    writer.print(currentName);
                    writer.print(": ");
                    writer.println(500000);
                } else if (currentName.contains("Mr") || currentName.contains("Mrs")) {
                    writer.print(currentName);
                    writer.print(": ");
                    writer.println(200000);
                } else {
                    writer.print(currentName);
                    writer.print(": ");
                    writer.println(100000);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file!");
        }
    }

}
