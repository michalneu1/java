package org.example;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, String model, int year, FuelType fuelType, double tank, double fuelConsumption, int doors) {
        super(brand, model, year, fuelType, tank, fuelConsumption);
        this.doors = doors;
    }

    @Override
    public String toString() {
        return String.format("Car{doors=%d, %s}",doors,super.toString());
    }

    public int getDoors() {
        return doors;
    }
}
