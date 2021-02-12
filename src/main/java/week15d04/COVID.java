package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class COVID {

    public COVID(String name) {
        readFromString(name);
    }

    List<WeeklyCase> hungarianCases = new ArrayList<>();
    static final int AMOUNT_OF_WEEKS_NEEDED = 3;

    public void readFromString(String name) {
        Path path = Path.of(name);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.contains(",Hungary,")) {
                    String date = (line.split(",")[0]);
                    int cases = Integer.parseInt(line.split(",")[2]);
                    hungarianCases.add(new WeeklyCase(date, cases));
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }
    }

    public List<WeeklyCase> mostCasesByWeek(){

        List<WeeklyCase> copy= new ArrayList<>(hungarianCases);
        Collections.sort(copy);
        return new ArrayList<>(copy.subList(0,AMOUNT_OF_WEEKS_NEEDED));
    }

    public static void main(String[] args) {
        COVID covid = new COVID("src/main/resources/data.csv");
        System.out.println(covid.mostCasesByWeek().toString());
    }
}
