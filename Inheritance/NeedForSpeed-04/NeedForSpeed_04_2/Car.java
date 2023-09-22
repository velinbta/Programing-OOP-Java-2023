package NeedForSpeed_04_2;

public class Car extends Vehicle {

    public static final double DEFAULT_FUEL_CONSUMPTION = 3D;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

}
