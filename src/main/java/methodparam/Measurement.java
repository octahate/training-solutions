package methodparam;

public class Measurement {
    private double[] values;

    public Measurement(double[] values) {
        this.values = values;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i= 0; i < values.length; i++ ) {
            if (values[i] > lower || values [i] < upper ){
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double temp = values[0];
        for (int i = 1; i < values.length; i++) {
            if (temp <= values[i]) {
                temp = values [i];
            }
        }
        return temp;
    }

    public double maximum() {
        double temp = values[0];
        for (int i = 1; i < values.length; i++) {
            if (temp >= values[i]) {
                temp = values [i];
            }
        }
        return temp;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }

}
