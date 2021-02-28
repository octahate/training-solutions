package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String,Integer> owlsByRegion = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine())  != null) {
            String[] divide = line.split("=");
            owlsByRegion.put(divide[0],Integer.parseInt(divide[1]));
        }
    }

    public int getNumberOfOwls(String region){
        if (owlsByRegion.containsKey(region)){
           return owlsByRegion.get(region);
        }
        else {
            throw new IllegalArgumentException("Such region is not in our database!");
        }
    }

}
