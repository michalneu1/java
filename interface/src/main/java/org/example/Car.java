package org.example;

public class Car extends Vehicle implements Drivable {
    private byte doors;

    public Car(String brand, String model, int year, FuelType fuelType, int tank, int usageTank, byte doors) {
        super(brand, model, year, fuelType, tank, usageTank);
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "doors=" + doors +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelType=" + fuelType +
                ", tankSize=" + tankSize +
                ", currentTankValue=" + currentTankValue +
                ", usageTank=" + usageTank +
                '}';
    }
}
