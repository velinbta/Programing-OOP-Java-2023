package Vehicles_01_2;

public class Car extends Vehicle {

    public static final double DEFAULT_EXTRA_SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public void refuel(double liters) {
        this.ensurePositiveParameter(liters, "Liters");
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    protected double calculateConsumption(double distance) {
        return (this.getLitersPerKm() + DEFAULT_EXTRA_SUMMER_CONSUMPTION) * distance;
    }

}
