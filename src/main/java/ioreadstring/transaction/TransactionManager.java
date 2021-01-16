package ioreadstring.transaction;

import exceptionclass.bank.Bank;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList = new ArrayList<>();

    public TransactionManager() {
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void uploadListFromFile(String path) {
        Path accountsPath = Path.of(path);
        List<String> importedAccounts;
        try {
            importedAccounts = Files.readAllLines(accountsPath);
        } catch (IOException ex) {
            throw new IllegalStateException("Can't read file", ex);
        }

        for (String currentAccount : importedAccounts) {
            int firstComma = currentAccount.indexOf(';');
            int secondComma = currentAccount.indexOf(';', firstComma+1);
            accountList.add(new BankAccount(
                            currentAccount.substring(0,firstComma),
                            currentAccount.substring((firstComma + 1), secondComma),
                    Integer.parseInt(currentAccount.substring(secondComma +1))
            ));
        }
    }

    public void makeTransactions(String path) {
        Path transactionsPath = Path.of(path);
        List<String> transactionsList;
        try {
            transactionsList = Files.readAllLines(transactionsPath);
        } catch (IOException ex) {
            throw new IllegalStateException("Can't read file", ex);
        }
        for (String currentTransaction : transactionsList) {
            String currentAccount = currentTransaction.substring(0, currentTransaction.indexOf(';'));
            for (int i = 0; i < accountList.size(); i++) {
                if (currentAccount.equals(accountList.get(i).getAccountNumber())) {
                    accountList.get(i).setBalance(Integer.parseInt(currentTransaction.substring(currentTransaction.indexOf(';')+1)));
                }
            }
        }
    }
}
