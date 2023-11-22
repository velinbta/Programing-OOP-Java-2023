package christmasRaces.entities.cars;

public class MuscleCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 5000D;
    private static final int DEFAULT_MINIMUM_HORSE_POWER = 400;
    private static final int DEFAULT_MAXIMUM_HORSE_POWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS,
                DEFAULT_MINIMUM_HORSE_POWER, DEFAULT_MAXIMUM_HORSE_POWER);
    }

}
