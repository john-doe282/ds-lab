package entities;

public final class RentInfo {
    private final int price;
    private final Car car;

    public RentInfo(int price, Car car) {
        this.price = price;
        this.car = car;
    }

    public int getPrice() {
        return price;
    }

}
