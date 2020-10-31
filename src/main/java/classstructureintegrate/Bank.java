package classstructureintegrate;

public class Bank {
    public static void main(String[] args) {
        BankAccount accountone = new BankAccount("1123534", "Geli", 120);
        System.out.println(accountone.getInfo());
        accountone.deposit(12);
        System.out.println(accountone.getInfo());
        accountone.withdraw(4);
        System.out.println(accountone.getInfo());
        BankAccount accounttwo = new BankAccount("11223434","Peti", 56102);
        System.out.println(accountone.getInfo());
        accounttwo.deposit(12);
        System.out.println(accounttwo.getInfo());
        accounttwo.withdraw(4);
        System.out.println(accounttwo.getInfo());
        accountone.transfer(accounttwo, 365);
        System.out.println(accounttwo.getInfo());
        System.out.println(accountone.getInfo());
        accounttwo.transfer(accountone, 365);
        System.out.println(accounttwo.getInfo());
        System.out.println(accountone.getInfo());


    }
}
