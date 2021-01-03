package inheritancemethods.bankaccount;

public class DebitAccount {

    String accountNumber;
    long balance;
    public static final double COST = 3.0;
    public static final double MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final long costOfTransaction(long amount){
        long cost = (long) (amount*COST/100);
        if (cost < MIN_COST){
            return (long) MIN_COST; }
        else { return cost;
        }
    }

    public boolean transaction(long amount){
        long cost = costOfTransaction(amount);
        if (cost+amount > balance){
            return false;
        }
        balance = balance - (cost+amount);
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void balanceToZero(){
        balance = 0;
    }

}
