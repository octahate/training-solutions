package exceptions.polinom;

import static java.lang.Double.parseDouble;

public class Polynomial {

    private double[] coefficientStrs;

    public Polynomial(double[] coefficientStrs) {
        if (coefficientStrs == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficientStrs = coefficientStrs;
    }

    public Polynomial(String[] coefficientStrs) {
        if (coefficientStrs == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        try {
            this.coefficientStrs = new double[coefficientStrs.length];
            for (int i = 0; i < coefficientStrs.length; i++) {
                this.coefficientStrs[i] = parseDouble(coefficientStrs[i]);
            }
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("Illegal coefficients, not a number", ex);
        }
    }

    public double[] getCoefficients() {
        return coefficientStrs;
    }

    public double evaluate(double x) {
        double result = 1;
        for (double currentValue : coefficientStrs) {
            result = result * (currentValue + x);
        }
        return result;
    }
}
