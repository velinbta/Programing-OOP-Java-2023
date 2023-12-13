package easterRaces.entities.cars;

public class MuscleCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 5000D;
    private static final int MIN_HORSEPOWER = 400;
    private static final int MAX_HORSEPOWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS, MIN_HORSEPOWER, MAX_HORSEPOWER);
    }

}
