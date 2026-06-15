package org.example;

public abstract class Vehicle implements Drivable {
    private String brand;
    private String model;
    private int year;
    private FuelType fuelType;
    private double tankSize;
    private double fuelConsumption;
    private double currentTankValue;

    public Vehicle(String brand, String model, int year, FuelType fuelType, double tank, double fuelConsumption) {
        setBrand(brand);
        setModel(model);
        setYear(year);
        setFuelType(fuelType);
        setTankSize(tank);
        setFuelConsumption(fuelConsumption);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null ) {
            throw new IllegalArgumentException("Marka nie może być pusta");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null ) {
            throw new IllegalArgumentException("Model nie może być pusty");
        }
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if ( year <= 2026) {
            throw new IllegalArgumentException("Rok musi być mniejszy/równy 2026, podano: " + year);
        }
        this.year = year;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        if (fuelType == null) {
            throw new IllegalArgumentException("Typ paliwa nie może być null");
        }
        this.fuelType = fuelType;
    }

    public double getTankSize() {
        return tankSize;
    }

    public void setTankSize(double tankSize) {
        if (tankSize <= 0) {
            throw new IllegalArgumentException("Pojemność baku musi być większa od 0, podano: " + tankSize);
        }
        this.tankSize = tankSize;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        if (fuelConsumption <= 0) {
            throw new IllegalArgumentException("Spalanie musi być większe od 0, podano: " + fuelConsumption);
        }
        this.fuelConsumption = fuelConsumption;
    }

    public double getCurrentTankValue() {
        return currentTankValue;
    }


    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelType=" + fuelType +
                ", tankSize=" + tankSize +
                ", fuelConsumption=" + fuelConsumption +
                ", currentTankValue=" + currentTankValue +
                '}';
    }

    public void drive(double km) {
        if (km <= 0) {
            System.out.println("Dystans musi być większy od 0");
            return;
        }
        double needed = fuelConsumption * km / 100.0;
        if (this.currentTankValue <= 0) {
            System.out.println("Brak paliwa");
            return;
        }
        if (this.currentTankValue < needed) {
            System.out.printf("Za mało paliwa aby przejechać %.1f km (potrzeba %.2f, masz %.2f)%n",
                    km, needed, currentTankValue);
            return;
        }
        this.currentTankValue -= needed;
        System.out.printf("Przejechano %.1f km, zużyto %.2f paliwa%n", km, needed);
    }

    public void refuel(double value) {
        if (value <= 0) {
            System.out.println("Ilość paliwa musi być większa od 0");
            return;
        }
        double freeSpace = tankSize - currentTankValue;
        if (freeSpace <= 0) {
            System.out.println("Bak jest już pełny");
            return;
        }
        double added = Math.min(value, freeSpace);
        currentTankValue += added;
        double cost = fuelType.getPrice() * added;
        System.out.printf("Zatankowano %.2f %s, cena: %.2f%n", added, fuelType.name(), cost);
        if (added < value) {
            System.out.printf("Nie zmieściło się %.2f (bak pełny)%n", value - added);
        }
    }
}
