package org.example;

public abstract class Vehicle implements Drivable {
    protected String brand;
    protected String model;
    protected int year;
    protected FuelType fuelType;
    protected double tankSize;
    protected double usageTank;
    protected double currentTankValue;

    public Vehicle(String brand, String model, int year, FuelType fuelType, int tank, int usageTank) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.tankSize = tank;
        this.usageTank = usageTank;
    }


    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelType=" + fuelType +
                ", tankSize=" + tankSize +
                ", usageTank=" + usageTank +
                ", currentTankValue=" + currentTankValue +
                '}';
    }

    public void drive() {
        if (this.currentTankValue <= 0) {
            System.out.println("Brak paliwa");
            return;
        }
        if (this.currentTankValue - this.usageTank < 0) {
            System.out.println("Za mało paliwa aby dojechać");
            return;
        }
        this.currentTankValue -= this.usageTank;
        System.out.printf("Zużyto: %f paliwa%n", usageTank);

    }

    public void refuel(double value) {
        System.out.println("cena paliwa: " + this.fuelType.getPrice() * value);
        if (currentTankValue + value > tankSize) {
            System.out.printf("Za dużo %s!%n", fuelType.name());
            currentTankValue = tankSize;
            return;
        }
        currentTankValue += value;
        System.out.println("zatankowano: " + value);
    }
}
