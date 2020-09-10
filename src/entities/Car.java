package entities;

import java.util.UUID;

public final class Car {
    private final UUID carId;
    private final String model;
    private final String type;
    private int pricePerHour;
    private final Owner owner;
    private Status status;

    public Car (String model, String type, int pricePerHour,
                Owner owner) {
        this.model = model;
        this.type = type;
        this.pricePerHour = pricePerHour;
        this.owner = owner;
        this.status = Status.AVAILABLE;
        carId = UUID.randomUUID();
    }

    @Override
    public String toString() {
        String description = "Car model: " + model + "\n";
        description += "Car type: " + type + "\n";
        description += "Owner: " + owner + "\n";
        description += "Price per hour: " + pricePerHour + "\n";
        description += "The car is";
        if (status == Status.RENTED) {
            description += " not";
        }
        description += " available" + "\n";
        return description;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public boolean isAvailable() {
        return status == Status.AVAILABLE;
    }

    public void setPricePerHour(int pricePerHour) {
//      Will be used when the owner decides to change the rent
        this.pricePerHour = pricePerHour;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setAvailable() {
        status = Status.AVAILABLE;
    }

    public void setRented() {
        status = Status.RENTED;
    }

    public UUID getCarId() {
        return carId;
    }
}
