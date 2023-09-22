package NeedForSpeed_04_2;

public class SportCar extends Car {

    public static final double DEFAULT_FUEL_CONSUMPTION = 10D;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

}
