package org.example;

public class Motorcycle extends Vehicle implements Drivable {

    public Motorcycle(String brand, String model, int year, FuelType fuelType, int tank, int usageTank) {
        super(brand, model, year, fuelType, tank, usageTank);
    }
}
