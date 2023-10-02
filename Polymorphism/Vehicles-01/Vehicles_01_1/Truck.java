package Vehicles_01_1;

public class Truck extends Vehicle {

    public static final double DEFAULT_SUMMER_LITERS_INCREASE = 1.6;
    public static final double DEFAULT_REFUEL_MULTIPLIER_DECREASE = 0.95;

    public Truck(double fuelQuantity, double litersPerKm) {
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
        // 95% of fuel
        double actualLiters = liters * DEFAULT_REFUEL_MULTIPLIER_DECREASE;
        this.setFuelQuantity(this.getFuelQuantity() + actualLiters);
    }

}
