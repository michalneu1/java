package org.example;

public enum FuelType {
    PETROL(5.0), DIESEL(6.0), ELECTRIC(3.0);

    private FuelType(double price) {
        this.price = price;
    }

    private final double price;

    public double getPrice() {
        return price;
    }
}
