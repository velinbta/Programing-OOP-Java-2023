package Vehicles_01_2;

public class Car extends Vehicle {

    public static final double DEFAULT_EXTRA_SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public boolean drive(double distance) {
        this.ensurePositiveParameter(distance, "Distance");

        double consumption = this.calculateConsumption(distance);
        boolean canDrive = consumption <= this.getFuelQuantity();

        if (canDrive)
            this.setFuelQuantity(this.getFuelQuantity() - consumption);

        return canDrive;
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
