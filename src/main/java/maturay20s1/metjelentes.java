package maturay20s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class metjelentes {

    private List<telegram> data = new ArrayList<>();
    private Map<String, List<Integer>> valuesForMean = new HashMap<>();
    private Map<String, List<Integer>> valuesForMinMax = new HashMap<>();

    public metjelentes(String path) {
        readLines(path);
        turnDataIntoValuesMap();
        turnDataIntoMinMaxMap();
    }

    private void readLines(String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("VRB")) {
                    data.add(new telegram(line.split(" ")[0],
                            LocalTime.of(Integer.parseInt(line.split(" ")[1].substring(0, 2)), Integer.parseInt(line.split(" ")[1].substring(2))),
                            false,
                            line.split(" ")[2].substring(0, 3),
                            line.split(" ")[2].substring(3),
                            Integer.parseInt(line.split(" ")[3])));
                } else {
                    data.add(new telegram(line.split(" ")[0],
                            LocalTime.of(Integer.parseInt(line.split(" ")[1].substring(0, 2)), Integer.parseInt(line.split(" ")[1].substring(2))),
                            true,
                            line.split(" ")[2].substring(3),
                            Integer.parseInt(line.split(" ")[3])));
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }
    }

    public LocalTime latestDataFromCity(String city) {
        for (int i = data.size() - 1; i > 0; i--) {
            if (data.get(i).getLocation().equals(city)) {
                return data.get(i).getDate();
            }
        }
        throw new IllegalArgumentException("Cannot find city!");
    }

    public String noWind() {
        StringBuilder sb = new StringBuilder();
        for (telegram currentPlace : data) {
            if (!currentPlace.isWindVariable() &&
                    currentPlace.getWindDirection().equals("000") &&
                    currentPlace.getWindStrength().equals("00")) {
                sb.append(currentPlace.getLocation());
                sb.append(" ");
                sb.append(currentPlace.getDate().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private void turnDataIntoValuesMap() {
        for (telegram current : data) {
            if (!valuesForMean.containsKey(current.getLocation())) {
                valuesForMean.put(current.getLocation(), new ArrayList<>());
            }
            if ((current.getDate().getHour() == 1) ||
                    (current.getDate().getHour() == 7) || (current.getDate().getHour() == 13)
                    || (current.getDate().getHour() == 19)) {
                valuesForMean.get(current.getLocation()).add(current.getTemperature());
            }
        }
    }

    private void turnDataIntoMinMaxMap() {
        for (telegram current : data) {
            if (!valuesForMinMax.containsKey(current.getLocation())) {
                valuesForMinMax.put(current.getLocation(), new ArrayList<>());
            }
            valuesForMinMax.get(current.getLocation()).add(current.getTemperature());
        }
    }

    public String MinMaxValues(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Integer>> current : valuesForMinMax.entrySet()) {
            Collections.sort(current.getValue());
            int min = Collections.min(current.getValue());
            int max = Collections.max(current.getValue());
            int diff = max - min;
            sb.append(current.getKey());
            sb.append(" ");
            sb.append(diff);
            sb.append("\n");
        }
        return sb.toString();
    }

    private String calculateMeans() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Integer>> current : valuesForMean.entrySet()) {
            int sum = 0;
            String value = null;
            for (Integer amount : current.getValue()) {
                sum = sum + amount;
            }
            if (current.getValue().size() < 5) {
                value = "NA";
            } else {
                sum = (int) (sum / (current.getValue().size() * 1.0));
                value = String.valueOf(sum);
            }
            sb.append(current.getKey());
            sb.append(" ");
            sb.append(value);
            sb.append("\n");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        metjelentes mj = new metjelentes("src/main/java/maturay20s1/tavirathu13.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("2. feladat");
        System.out.println("Adja meg a település kódját!");
        String city = scanner.next();
        System.out.println("Település:" + city);
        System.out.println(mj.latestDataFromCity(city));
        System.out.println(mj.noWind());
        System.out.println(mj.valuesForMean.toString());
        System.out.println(mj.calculateMeans());
        System.out.println(mj.MinMaxValues());
    }
}
