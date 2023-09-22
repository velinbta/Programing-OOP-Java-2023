package NeedForSpeed_04_2;

public class Vehicle {

    public static final double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
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

    public void drive(double kilometers) {

        double fuelNeeded = kilometers * this.getFuelConsumption();

        boolean isFuelEnough = fuelNeeded <= this.getFuel();
        if (!isFuelEnough)
            return;

        this.setFuel(this.getFuel() - fuelNeeded);
    }

}
