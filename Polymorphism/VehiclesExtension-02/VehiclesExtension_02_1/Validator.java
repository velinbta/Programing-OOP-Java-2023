package VehiclesExtension_02_1;

public class Validator {

    private Validator() {
        // Don't let anyone instantiate an instance of this class
    }

    public static void validateParameter(boolean check, String parameterName) {
        if (check) // <- case [< 0 or <= 0]
            throw argumentException(String.format("%s must be a positive number", parameterName));
    }

    public static void validateFuel(double tankCapacity, double fuelQuantity) {
        if (fuelQuantity > tankCapacity)
            throw argumentException("Cannot fit fuel in tank");
    }

    private static IllegalArgumentException argumentException(String message) {
        throw new IllegalArgumentException(message);
    }

}
