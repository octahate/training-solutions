package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StateRegister {

    private List<State> states;

    public void readStatesFromFile(String stringFileName){
        Path filePlace = Path.of("src/main/resources/idread" + stringFileName);
        String currentLine;
        try (BufferedReader reader = Files.newBufferedReader(filePlace)){
            while ((currentLine = reader.readLine()) != null){
                int separetor = reader.readLine().charAt('-');
                states.add(new State(currentLine.substring(0,separetor), currentLine.substring(separetor+1)));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file!",e);
        }

    }
}
