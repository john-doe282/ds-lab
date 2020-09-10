package entities;

public abstract class User {
    protected String name;
    protected LoginCredentials loginCredentials;
    protected BankAccount bankAccount;
    protected String email;

    User(String name, LoginCredentials loginCredentials,
         BankAccount bankAccount, String email) {
        this.name = name;
        this.loginCredentials = loginCredentials;
        this.bankAccount = bankAccount;
        this.email = email;
    }
    public String getName() {
        // will be used in the ui
        return name;
    }

    public LoginCredentials getLoginCredentials() {
        // will be used for authorization
        return loginCredentials;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public String getEmail() {
        // will be used in the ui
        return email;
    }

    public void setName(String name) {
        // will be used if a user decides to change their name
        this.name = name;
    }


    public void setBankAccount(BankAccount bankAccount) {
        // will be used if user's bank accounts has changed
        this.bankAccount = bankAccount;
    }

    public void setEmail(String email) {
        // will be used if user's email address has changed
        this.email = email;
    }

    @Override
    public String toString() {
        String description = "Name: " + name;
        return description;
    }
}

