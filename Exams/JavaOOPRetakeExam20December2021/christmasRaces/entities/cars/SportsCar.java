package christmasRaces.entities.cars;

public class SportsCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 3000D;
    private static final int DEFAULT_MINIMUM_HORSE_POWER = 250;
    private static final int DEFAULT_MAXIMUM_HORSE_POWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS,
                DEFAULT_MINIMUM_HORSE_POWER, DEFAULT_MAXIMUM_HORSE_POWER);
    }

}
