import entities.*;
import services.AuthService;
import services.MarketService;
import services.PaymentService;

public class Main {
    public static Owner generateOwner(int idx) {
        String name = "owner_" + idx;

        String login = "ow_login_" + idx;
        String password = "pass";
        LoginCredentials loginCredentials = new LoginCredentials(login, password);

        String iban = "1234567" + idx;
        BankAccount bankAccount = new BankAccount(iban, 2345);

        String email = idx + "@ukr.net";

        Owner owner = new Owner(name, loginCredentials, bankAccount, email);
        return owner;

    }

    public static Client generateClient() {
        String name = "john";
        LoginCredentials loginCredentials = new LoginCredentials("login", "pass");
        BankAccount bankAccount = new BankAccount("12345678", 234);
        String email = "john@icloud.com";

        Client client = new Client(name, loginCredentials, bankAccount, email);
        return client;
    }

    public static Car generateCar(Owner owner, String model) {
        Car car = new Car(model, "SUV", 23, owner);
        return car;
    }

    private final static MarketPlace marketPlace = new MarketPlace();

    public static void main(String[] args) {
        final MarketPlace marketPlace = new MarketPlace();
        final PaymentService paymentService = new PaymentService();
        final AuthService authService = new AuthService(marketPlace);
        final MarketService marketService = new MarketService(2, 0.3, paymentService);
        final String accessory = "--------------------------";

        System.out.println("Initial state");
        marketPlace.printState();

        Client client = generateClient();

        // Adding new clients to the marketPlace
        authService.registerClient(client);

        // Creating new owners
        Owner owner1 = generateOwner(1);
        Owner owner2 = generateOwner(2);

        // Adding owners to the marketPlace
        authService.registerOwner(owner1);
        authService.registerOwner(owner2);

        System.out.println(accessory);
        System.out.println("marketPlace state after adding clients and owners");
        marketPlace.printState();

        // Creating cars
        Car car1 = generateCar(owner1, "ZAZ");
        Car car2 = generateCar(owner2, "LADA");

        // Adding new cars to the marketPlace
        marketService.addCar(car1, marketPlace);
        marketService.addCar(car2, marketPlace);


        System.out.println(accessory);
        System.out.println("marketPlace state after adding cars");
        marketPlace.printState();

        // Renting a car
        try {
            marketService.rent(client, car1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("The car is not available");
        }

        System.out.println(accessory);
        System.out.println("marketPlace state after renting a car");
        marketPlace.printState();

        // Renting a car that is already in use - exception expected
        try {
            marketService.rent(client, car1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("The car is not available");
        }

        // Closing rent - should be successful
        try {
            marketService.closeRent(client, car1);
            System.out.println("Closing rent");
        } catch (IllegalArgumentException e) {
            System.out.println("The car has not been rented to this client");
        }

        System.out.println(accessory);
        System.out.println("marketPlace state after returning the car");
        marketPlace.printState();

        // Renting another car - should be successful
        try {
            marketService.rent(client, car2, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("The car is not available");
        }

        // Canceling rent after closing it - exception expected
        try {
            marketService.cancelRent(client, car1);
        } catch (IllegalArgumentException e) {
            System.out.println("The car has not been rented to this client");
        }

        // Removing car2 from the marketPlace
        marketService.deleteCar(car2, marketPlace);

        System.out.println(accessory);
        System.out.println("marketPlace state after deleting a car");
        marketPlace.printState();

        System.out.println(accessory);
        System.out.println("Simulation successful");
    }
}
