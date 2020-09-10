package services;
import entities.BankAccount;

public final class PaymentService {
    public void transaction(BankAccount sender,
                                   BankAccount receiver, int amount) {
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
    }
}
