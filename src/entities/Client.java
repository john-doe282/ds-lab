package entities;

import java.util.HashMap;
import java.util.UUID;

public final class Client extends User {
    private final HashMap<UUID, RentInfo> activeRents;

    public Client(String name, LoginCredentials loginCredentials,
                  BankAccount bankAccount, String email) {
        super(name, loginCredentials, bankAccount, email);
        activeRents = new HashMap<>();
    }

    public void addCar(Car car, int price) {
        UUID carId = car.getCarId();
        RentInfo rentInfo = new RentInfo(price, car);
        activeRents.put(carId, rentInfo);
    }

    public void deleteFromRents(Car car) {
        UUID carId = car.getCarId();
        activeRents.remove(carId);
    }

    public boolean hasInActiveRents(Car car) {
        UUID carId = car.getCarId();
        return activeRents.containsKey(carId);
    }

    public int getPrice(Car car) {
        UUID carId = car.getCarId();
        int price = activeRents.get(carId).getPrice();
        return price;
    }
}