package methodstructure.bmi;

public class BodyMass {
    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return weight / Math.pow(height, 2);
    }

    public BmiCategory body() {
        double value = this.bodyMassIndex();
        if (value < 18.5)
            return BmiCategory.UNDERWEIGHT;
        if (value > 25)
            return BmiCategory.OVERWEIGHT;
        return BmiCategory.NORMAL;
    }

    public boolean isThinnerThan(BodyMass other) {
        if (other.bodyMassIndex() > this.bodyMassIndex()) {
            return true;
        } return false;
    }
}

