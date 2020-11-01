package statements;

public class Investment {
    private double cost;
    private double fund;
    private int interestRate;
    private boolean active;

    public Investment(double fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        active = true;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public double getFund() {
        return fund;
    }

    public double getYield(int days) {
       return  fund * interestRate * days;
    }
    public double close (int days) {
        if (active == false) {
            return 0;
        } else {
            active = false;
            return fund + getYield(days);
            }
    }
}
