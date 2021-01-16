package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Register {

    public Register() {
    }

    public void newMark(Path studentName, int grade ){

    }

    public void newMark(String studentName, String grade) throws IOException {
        Path studentFile = Path.of(studentName + ".txt");
        Files.writeString(studentFile,grade);
    }
}
