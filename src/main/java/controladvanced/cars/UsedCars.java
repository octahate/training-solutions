package controladvanced.cars;

import java.util.ArrayList;
import java.util.List;

public class UsedCars {
    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 4) {
                if (parts[0].length() == 7 && parts[0].contains("-")) {
                    int value = Integer.parseInt(parts[1]);
                    if (value > 1970 && value < 2019) {
                        validLines.add(line);
                    }
                }
            }
        }
        return validLines;
    }
}
