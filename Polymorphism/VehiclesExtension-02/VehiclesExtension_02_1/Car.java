package VehiclesExtension_02_1;

public class Car extends Vehicle {

    public static final double DEFAULT_EXTRA_SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    protected double calculateConsumptionWithAC(double distance) {
        return (this.getLitersPerKm() + DEFAULT_EXTRA_SUMMER_CONSUMPTION) * distance;
    }

}
