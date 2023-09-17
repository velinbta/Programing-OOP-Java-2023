package PizzaCalories_04_1;

import java.util.Arrays;

public class Topping {

    private enum ToppingType {

        MEAT(1.2),
        VEGGIES(0.8),
        CHEESE(1.1),
        SAUCE(0.9);

        private final double modifier;

        ToppingType(double modifier) {
            this.modifier = modifier;
        }

        public static boolean containsIgnoreCase(String type) { // <- check if enum exists
            return Arrays.stream(ToppingType.values()).map(String::valueOf)
                    .anyMatch(topping -> topping.equalsIgnoreCase(type));
        }

        public static ToppingType parse(String type) { // <- parse enum from String
            type = type.toUpperCase();

            switch (type) {

                case "MEAT":
                    return MEAT;
                case "VEGGIES":
                    return VEGGIES;
                case "CHEESE":
                    return CHEESE;
                case "SAUCE":
                    return SAUCE;
            }

            throw new IllegalArgumentException(String.format("Type not found: %s", type));
        }

    }

    private static final double BASE_CALORIES_PER_GRAM = 2D;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String type) {
        if (!ToppingType.containsIgnoreCase(type)) // <- if enum unknown
            throw stateException(String.format("Cannot place %s on top of your pizza.", type));
        this.toppingType = type;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) // <- range
            throw stateException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        this.weight = weight;
    }

    public double calculateCalories() {
        return (BASE_CALORIES_PER_GRAM * this.weight) * ToppingType.parse(this.toppingType).modifier;
    }

    private IllegalStateException stateException(String message) {
        throw new IllegalStateException(message);
    }

}
