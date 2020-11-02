package statements;

public class Investment {
    private double cost = 0.3;
    private int fund;
    private int interestRate;
    private boolean active;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        this.active = true;
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
