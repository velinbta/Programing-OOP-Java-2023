package Vehicles_01_1;

public class Car extends Vehicle {

    public static final double DEFAULT_SUMMER_LITERS_INCREASE = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public boolean drive(double distance) {
        double actualLitersPerKm = this.getLitersPerKm() + DEFAULT_SUMMER_LITERS_INCREASE;
        double fuelNeeded = distance * actualLitersPerKm;

        boolean canDrive = fuelNeeded <= this.getFuelQuantity();

        if (canDrive)
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);

        return canDrive;
    }

    @Override
    public void refuel(double liters) {
        // 100% of fuel
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

}
