package services;

import entities.*;

import java.util.ArrayList;

public final class MarketService {
    private final int cancellationPenalty;
    private final double tax;
    private final PaymentService paymentService;

    public MarketService(int cancellationPenalty, double tax,
                         PaymentService paymentService) {
        this.cancellationPenalty = cancellationPenalty;
        this.tax = tax;
        this.paymentService = paymentService;
    }

    public void rent(Client client,
                     Car car, int duration) throws IllegalArgumentException {
        Owner owner = car.getOwner();

        if (!car.isAvailable()) {
            throw new IllegalArgumentException("Car not available");
        }

        int amount = (int) (car.getPricePerHour() * duration * (1 - tax));
        paymentService.transaction(client.getBankAccount(),
                owner.getBankAccount(), amount);

        client.addCar(car, amount);
        car.setRented();
    }

    public void cancelRent(Client client, Car car) throws IllegalArgumentException {
        Owner owner = car.getOwner();

        if (!client.hasInActiveRents(car)) {
            throw new IllegalArgumentException("Car has not been rented to this user");
        }

        int amount = client.getPrice(car) - cancellationPenalty;
        paymentService.transaction(owner.getBankAccount(),
                client.getBankAccount(), amount);

        client.deleteFromRents(car);
        car.setAvailable();
    }

    public void closeRent(Client client, Car car) throws IllegalArgumentException {
        if (!client.hasInActiveRents(car)) {
            throw new IllegalArgumentException("Car has not been rented to this user");
        }

        client.deleteFromRents(car);
        car.setAvailable();
    }

    public void addCar(Car car, MarketPlace marketPlace) {
        ArrayList<Car> cars = marketPlace.getCars();
        if (!cars.contains(car)) {
            cars.add(car);
        }
    }

    public void deleteCar(Car car, MarketPlace marketPlace) {
        ArrayList<Car> cars = marketPlace.getCars();
        int idx = cars.indexOf(car);
        if (idx != -1) {
            cars.remove(idx);
        }
    }

}
