package week15d01;

import java.util.Map;

public class Coordinates {

    private Map<Double, Double> graph;

    public Coordinates(Map<Double, Double> graph) {
        this.graph = graph;
    }

    public Map.Entry<Double, Double> maxValue() {
        Map.Entry<Double, Double> maxElement = null;
        double max = Double.MIN_VALUE;

        for (Map.Entry<Double, Double> currentKey : graph.entrySet()) {
            if (max < currentKey.getValue()) {
                maxElement = currentKey;
                max = currentKey.getValue();
            }
        }
        return maxElement;

    }
}

