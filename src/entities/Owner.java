package entities;

public final class Owner extends User {
    public Owner(String name, LoginCredentials loginCredentials,
                 BankAccount bankAccount, String email) {
        super(name, loginCredentials, bankAccount, email);
    }

}
