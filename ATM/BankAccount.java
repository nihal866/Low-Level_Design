package ATM;

public class BankAccount {
    String name;
    int balance;
    String accountNumber;

    public BankAccount(String name, int balance, String accountNumber){
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void updateBalance(int deductedAmount){
        setBalance(balance - deductedAmount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
