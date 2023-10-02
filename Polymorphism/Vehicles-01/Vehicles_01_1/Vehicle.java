package Vehicles_01_1;

public abstract class Vehicle {

    private double fuelQuantity;
    private double litersPerKm;

    protected Vehicle(double fuelQuantity, double litersPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setLitersPerKm(litersPerKm);
    }

    public abstract boolean drive(double distance);

    public abstract void refuel(double liters);

    protected void setFuelQuantity(double fuelQuantity) {
        this.ensurePositiveParameter(fuelQuantity, "Fuel");
        this.fuelQuantity = fuelQuantity;
    }

    protected void setLitersPerKm(double litersPerKm) {
        this.ensurePositiveParameter(litersPerKm, "Liters");
        this.litersPerKm = litersPerKm;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    private void ensurePositiveParameter(double value, String parameterName) {
        if (value < 0D) // <- Not negative
            throw new IllegalArgumentException(String.format("%s can't hold a negative value", parameterName));
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

}
