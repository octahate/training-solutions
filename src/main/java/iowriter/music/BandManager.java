package iowriter.music;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> importBands(String filename) {
        List<Band> returnedBanks = new ArrayList<>();
        Path file = Path.of("/src/main/resources/iowriter" + filename);
        try (BufferedReader bandReader = Files.newBufferedReader(file)){
            String currentLine;
            while ((currentLine = bandReader.readLine()) != null) {
                String[] currentBand;
                currentBand = currentLine.split(";");
                returnedBanks.add(new Band(currentBand[0], Integer.getInteger(currentBand[1])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
        return returnedBanks;
    }


    public void writeBandsBefore(String outputFile, int year){
        List<Band> bandsFromFile = new ArrayList<>(importBands("bands_and_years.txt"));
        List<Band> outputList = new ArrayList<>();
        for (Band band : bandsFromFile) {
            if (band.getYear() < year) {
                outputList.add(band);
            }
        }
        Path output = Path.of(outputFile);
        try (BufferedWriter bw = Files.newBufferedWriter(output)){
            for (Band currentBand : outputList){
                bw.write(currentBand.toString() + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file!",e);
        }
    }


}

