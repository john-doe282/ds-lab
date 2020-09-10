package entities;

public final class BankAccount {
    private final String iban;
    private int balance;

    public BankAccount(String iban, int balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getIban() {
        // is required for real-life transactions
        return iban;
    }
}
