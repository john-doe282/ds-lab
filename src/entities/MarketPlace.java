package entities;

import java.util.ArrayList;

public final class MarketPlace {
    private final ArrayList<Client> clients;
    private final ArrayList<Owner> owners;
    private final ArrayList<Car> cars;

    public MarketPlace() {
        clients = new ArrayList<>();
        owners = new ArrayList<>();
        cars = new ArrayList<>();

    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void printState() {
        // prints out current state of marketPlace for demonstration purposes

        System.out.println("\nClients: ");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("Client #" + i);
            System.out.println(clients.get(i));
        }

        System.out.println("\nOwners: ");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println("Owner #" + i);
            System.out.println(owners.get(i));
        }

        System.out.println("\nCars: ");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car #" + i);
            System.out.println(cars.get(i));
        }
    }

}
