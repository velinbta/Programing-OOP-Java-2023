package VehiclesExtension_02_1;

public class Bus extends Vehicle {

    public static final double DEFAULT_EXTRA_SUMMER_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    protected double calculateConsumptionWithAC(double distance) {
        return (this.getLitersPerKm() + DEFAULT_EXTRA_SUMMER_CONSUMPTION) * distance;
    }

}
