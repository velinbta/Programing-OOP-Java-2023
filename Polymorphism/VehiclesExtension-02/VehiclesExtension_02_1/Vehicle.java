package VehiclesExtension_02_1;

public abstract class Vehicle {

    private double fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setLitersPerKm(litersPerKm);
        this.setTankCapacity(tankCapacity);
    }

    protected abstract double calculateConsumptionWithAC(double distance);

    public boolean driveWithAC(double distance) {
        Validator.validateParameter(distance < 0, "Distance");

        double consumption = this.calculateConsumptionWithAC(distance);
        boolean canDrive = consumption <= this.getFuelQuantity();

        if (canDrive)
            this.setFuelQuantity(this.getFuelQuantity() - consumption);

        return canDrive;
    }

    private double calculateConsumptionWithoutAC(double distance) {
        return this.getLitersPerKm() * distance;
    }

    public boolean driveWithoutAC(double distance) {
        Validator.validateParameter(distance < 0, "Distance");

        double consumption = this.calculateConsumptionWithoutAC(distance);
        boolean canDrive = consumption <= this.getFuelQuantity();

        if (canDrive)
            this.setFuelQuantity(this.getFuelQuantity() - consumption);

        return canDrive;
    }

    public void refuel(double liters) {
        Validator.validateParameter(liters <= 0, "Fuel");

        double totalFuel = this.getFuelQuantity() + liters;
        Validator.validateFuel(this.getTankCapacity(), totalFuel);

        this.setFuelQuantity(totalFuel);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        Validator.validateParameter(fuelQuantity < 0, "Fuel");
        // Initial fuelQuantity can contain more than actual tankCapacity!
        this.fuelQuantity = fuelQuantity;
    }

    private void setLitersPerKm(double litersPerKm) {
        Validator.validateParameter(litersPerKm < 0, "Liters");
        this.litersPerKm = litersPerKm;
    }

    private void setTankCapacity(double tankCapacity) {
        Validator.validateParameter(tankCapacity < 0, "Tank");
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

}
