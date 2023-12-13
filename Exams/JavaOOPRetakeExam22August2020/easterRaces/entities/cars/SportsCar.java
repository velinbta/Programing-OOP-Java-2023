package easterRaces.entities.cars;

public class SportsCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 3000D;
    private static final int MIN_HORSEPOWER = 250;
    private static final int MAX_HORSEPOWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS, MIN_HORSEPOWER, MAX_HORSEPOWER);
    }

}
