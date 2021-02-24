package maturay20s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Series {

    List<SeriesEntry> seriesList = new ArrayList<>();

    final static String NO_DATA = "NI";

    public List<SeriesEntry> getSeriesList() {
        return seriesList;
    }

    public void readFromString(String name) {
        Path path = Path.of(name);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String title;
            String date;
            String properties;
            int length;
            String hasWatched;
            boolean hasWatchedBoolean;
            while ((date = br.readLine()) != null) {
                title = br.readLine();
                properties = br.readLine();
                length = Integer.parseInt(br.readLine());
                hasWatched = br.readLine();
                if (hasWatched.equals("1")) {
                    hasWatchedBoolean = true;
                } else {
                    hasWatchedBoolean = false;
                }
                seriesList.add(
                        new SeriesEntry(date,
                                title,
                                Integer.parseInt(properties.substring(0, properties.indexOf('x'))),
                                Integer.parseInt(properties.substring(properties.indexOf('x') + 1)),
                                length,
                                hasWatchedBoolean));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }
    }

    public String hasADate() {
        int counter = 0;
        for (SeriesEntry entry : seriesList) {
            if (!NO_DATA.equals(entry.getDate())) {
                counter++;
            }
        }
        String result = "A listában " + counter + " db vetítési dátummal rendelkező epizód van. \n";
        return result;
    }

    public double percentageSeen() {
        int amountOfEpisodes = seriesList.size();
        int watchedEpisodes = 0;
        for (SeriesEntry entry : seriesList) {
            if (entry.isWatched()) {
                watchedEpisodes++;
            }
        }
        return (double) watchedEpisodes / amountOfEpisodes * 100.00;
    }

    public String amountOfTimeWatched() {
        int watchTime = 0;
        for (SeriesEntry entry : seriesList) {
            if (entry.isWatched()) {
                watchTime += entry.getLength();
            }
        }

        int days = (watchTime / 60) / 24;
        int hours = (watchTime - (days * 60 * 24)) / 60;
        int minutes = watchTime - (days * 60 * 24) - (hours * 60);
        return "Sorozatnézéssel " + days + " napot " + hours + " órát és " + minutes + " percet töltött.";
    }

    public void returnEpisodes(String date){
        String[] dateArray = date.split(".");
        int[] dateArrayint = new int[dateArray.length];
        for (int i = 0; i < dateArray.length ; i++) {
            dateArrayint[i] = Integer.parseInt(dateArray[i]);
        }
        for (SeriesEntry entry : seriesList) {
            String[] entryArray = entry.getDate().split(".");
            int[] entryArrayint = new int[entryArray.length];
            for (int i = 0; i < dateArray.length ; i++) {
                entryArrayint[i] = Integer.parseInt(entryArray[i]);
            }
            if (entryArrayint[0] <= dateArrayint [0] &&
                    entryArrayint[1] <= dateArrayint [1] &&
                    entryArrayint[2] <= dateArrayint [2] ) {

            }
        }
    }

    public String hetnapja (int year, int month, int day){
        String[] napok = {"v", "h","k","sze","cs","p","szo"};
        int[] honapok = {0,3,2,5,0,3,5,1,4,6,2,4} ;
        if (month < 3){
            year = year - 1;}
        return napok[year + year/4 - year/100 + year/ 400 + honapok[month-1] + day % 7 ];
    }

    public static void main(String[] args) {
        Series series = new Series();
        series.readFromString("src/main/java/matura/y20s2/lista.txt");
        System.out.println("2. Feladat:");
        System.out.println(series.hasADate());
        System.out.println("3. Feladat:");
        System.out.println("A listában lévő epizódok " + series.percentageSeen() + " %-át látta");
        System.out.println("4. Feladat");
        System.out.println(series.amountOfTimeWatched());


    }

}
