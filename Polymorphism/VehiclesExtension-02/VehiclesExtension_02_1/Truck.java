package VehiclesExtension_02_1;

public class Truck extends Vehicle {

    public static final double DEFAULT_EXTRA_SUMMER_CONSUMPTION = 1.6;
    public static final double DEFAULT_TANK_DECREASED_CAPACITY_MULTIPLIER = 0.95;

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        Validator.validateParameter(liters <= 0, "Fuel");

        // 95% of the given fuel refueled
        double totalFuel = this.getFuelQuantity() + (liters * DEFAULT_TANK_DECREASED_CAPACITY_MULTIPLIER);
        Validator.validateFuel(this.getTankCapacity(), totalFuel);

        this.setFuelQuantity(totalFuel);
    }

    @Override
    protected double calculateConsumptionWithAC(double distance) {
        return (this.getLitersPerKm() + DEFAULT_EXTRA_SUMMER_CONSUMPTION) * distance;
    }

}
