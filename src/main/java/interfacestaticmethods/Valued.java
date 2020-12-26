package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

    static double sum(List<Valued> values) {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i).getValue();
        }
        return sum;
    }

}
