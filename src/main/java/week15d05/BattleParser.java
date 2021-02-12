package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BattleParser {
    Set<String> houses = new HashSet<>();
    List<String> housesList = new ArrayList<>();
    public static final int FIRST_PLACE = 5;
    public static final int LAST_PLACE = 12;


    public void readFromString(String name) {
        Path path = Path.of(name);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                lineParser(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }
    }

    private void lineParser(String currentLine) {
        String[] data = currentLine.split(",");
        for (int i = FIRST_PLACE; i <= LAST_PLACE; i++) {
            if (!data[i].isBlank() || !data[i].isEmpty()) {
                houses.add(data[i]);
                housesList.add(data[i]);
            }
        }
    }

    private String convertArraysAndReturnMostBattled() {
        List<String> housesListOnce = new ArrayList<>(houses);
        String[] housesArray = new String[housesListOnce.size()];
        for (int i = 0; i < housesListOnce.size(); i++) {
            housesArray[i] = housesListOnce.get(i);
        }
        int[]counterArray = new int[housesArray.length];

        for (int i = 0; i < housesList.size(); i++) {
            for (int j = 0; j < housesArray.length ; j++) {
                if (housesList.get(i).equals(housesArray[j])){
                    counterArray[j] = counterArray[j]+1;
                }
            }
        }
        int max = 0;
        int position = 0;
        for (int i = 0; i < counterArray.length ; i++) {
            if (counterArray[i] > max){
                max = counterArray[i];
                position = i;
            }
        }
        return "A " + housesArray[position] + " ház vett részt a legtöbb csatában" + max + "mennyiségben.";
    }


    public static void main(String[] args) {
        BattleParser bp = new BattleParser();
        bp.readFromString("src/main/resources/battles.csv");
        System.out.println(bp.convertArraysAndReturnMostBattled());
    }
}
