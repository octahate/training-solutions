package ioreaderclasspath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private final List<Country> countryList;

    public CountryStatistics() {
       countryList = new ArrayList<>();
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void readFromFile(String filepath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Country.class.getResourceAsStream(filepath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                countryList.add(new Country(line.substring(0,line.indexOf(" ")),Integer.parseInt(line.substring(line.indexOf(" ")+1))));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int numberOFCountries(){
        return countryList.size();
    }

    public Country mostBorderCountries(){ 
        Country currentBiggest = null;
        int biggestBorder = 0;
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getBorderCountries() > biggestBorder){
                biggestBorder = countryList.get(i).getBorderCountries();
                currentBiggest = countryList.get(i);
            }
        }
        return currentBiggest;
    }
}