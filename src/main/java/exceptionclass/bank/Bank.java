package exceptionclass.bank;

import java.util.List;

public class Bank {
    List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null){
            throw new IllegalArgumentException("Can't be null");
        }
        this.accounts = accounts;
    }


    public void payment(String accountNumber, double amount) {
        if (accountNumber == null){
            throw new IllegalArgumentException("Can't be null");
        }
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber.equals(accounts.get(i).getAccountNumber())) {
                accounts.get(i).subtract(amount);
                return;
            }
        } throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }

        public void deposit(String accountNumber, double amount) {
        if (accountNumber == null){
            throw new IllegalArgumentException("Can't be null");
        }
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber.equals(accounts.get(i).getAccountNumber())){
                accounts.get(i).deposit(amount);
                return;
            }
        } throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }

}
