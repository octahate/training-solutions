package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HeightStatistics {

    public void saveHeights(List<Integer> heights, Path path) {
        try(DataOutputStream dos = new DataOutputStream( new BufferedOutputStream(Files.newOutputStream(path)))) {
            dos.writeInt(heights.size());
            for (Integer currentHeight : heights){
                dos.writeInt(currentHeight);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file!", e);
        }
    }

}
