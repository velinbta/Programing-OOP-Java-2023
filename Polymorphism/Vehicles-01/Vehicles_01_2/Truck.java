package Vehicles_01_2;

public class Truck extends Vehicle {

    public static final double DEFAULT_EXTRA_SUMMER_CONSUMPTION = 1.6;
    public static final double DEFAULT_TANK_DECREASED_CAPACITY_MULTIPLIER = 0.95;

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public boolean drive(double distance) {
        ensurePositiveParameter(distance, "Distance");

        double consumption = this.calculateConsumption(distance);
        boolean canDrive = consumption <= this.getFuelQuantity();

        if (canDrive)
            this.setFuelQuantity(this.getFuelQuantity() - consumption);

        return canDrive;
    }

    @Override
    public void refuel(double liters) {
        this.ensurePositiveParameter(liters, "Liters");
        // 95%
        this.setFuelQuantity(this.getFuelQuantity() + (liters * DEFAULT_TANK_DECREASED_CAPACITY_MULTIPLIER));
    }

    @Override
    protected double calculateConsumption(double distance) {
        return (this.getLitersPerKm() + DEFAULT_EXTRA_SUMMER_CONSUMPTION) * distance;
    }

}
