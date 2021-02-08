package week15d01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Coordinates {

    private Map<Double, Double> graph;

    public Coordinates(Map<Double, Double> graph) {
        this.graph = graph;
    }

    public String maxValue() {
        double max = Collections.max(graph.values());
        double where = 0;

        for (Double currentKey : graph.keySet()) {
            if (graph.get(currentKey) == max) {
                where = currentKey;

            }

            return "A függvény a maximum értékét " + where + " helyen, " + max + "értéken veszi fel";

        }
    }
}
