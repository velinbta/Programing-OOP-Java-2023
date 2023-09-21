package NeedForSpeed_04_1;

public class Vehicle {

    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private int successfulDriveCount;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption; // Child classes may vary
    }

    public void drive(double kilometers) {
        // Based on traveled km and fuel consumption
        double fuelNeeded = kilometers * this.getFuelConsumption();

        boolean isFuelEnough = fuelNeeded <= this.getFuel();
        if (!isFuelEnough)
            return;

        successfulDriveCount++;
        this.setFuel(this.getFuel() - fuelNeeded);

    }

    private void setFuel(double fuel) {
        this.fuel = fuel;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public int getSuccessfulDriveCount() {
        return this.successfulDriveCount;
    }

    @Override
    public String toString() {
        return String.format("%s has %d horsepower and %.2f fuel left. It has been successfully driven %d time/s.",
                this.getClass().getSimpleName(), this.getHorsePower(), this.getFuel(), this.getSuccessfulDriveCount());
    }

}
