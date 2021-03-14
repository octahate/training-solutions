package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader br) {
        List<String> solution = new ArrayList<>();
        Collator coll = Collator.getInstance(Locale.getDefault());
        try (br) {
            String line;
            while ((line = br.readLine()) != null) {
                String currentStation;
                if (extractStationName(line)!= null){
                    currentStation = extractStationName(line);
                    br.readLine();
                    br.readLine();
                    br.readLine();
                    if (isThereAStorm(br.readLine())){
                        solution.add(currentStation);
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }
        coll.setStrength(Collator.PRIMARY);
        solution.sort(coll);
        return solution;
    }

    private String extractStationName(String line){
        if (line.contains("\"allomas\"")){
            String[] extract = line.split("\"");
            return extract[3];
        }
        return null;
    }

    private boolean isThereAStorm(String line){
        return line.contains("3");
    }

}
