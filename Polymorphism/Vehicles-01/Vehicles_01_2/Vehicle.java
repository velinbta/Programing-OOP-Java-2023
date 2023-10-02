package Vehicles_01_2;

public abstract class Vehicle {

    private double fuelQuantity;
    private double litersPerKm;

    protected Vehicle(double fuelQuantity, double litersPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setLitersPerKm(litersPerKm);
    }

    public boolean drive(double distance) {
        this.ensurePositiveParameter(distance, "Distance");

        double consumption = this.calculateConsumption(distance);
        boolean canDrive = consumption <= this.getFuelQuantity();

        if (canDrive)
            this.setFuelQuantity(this.getFuelQuantity() - consumption);

        return canDrive;
    }

    public abstract void refuel(double liters);

    protected abstract double calculateConsumption(double distance);

    protected void setFuelQuantity(double fuelQuantity) {
        this.ensurePositiveParameter(fuelQuantity, "Fuel");
        this.fuelQuantity = fuelQuantity;
    }

    private void setLitersPerKm(double litersPerKm) {
        this.ensurePositiveParameter(litersPerKm, "Liters per km");
        this.litersPerKm = litersPerKm;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    protected void ensurePositiveParameter(double value, String parameterName) {
        if (value < 0D)
            throw this.argumentException(parameterName);
    }

    private IllegalArgumentException argumentException(String parameterName) {
        throw new IllegalArgumentException(String.format("%s can't hold a negative value", parameterName));
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

}
