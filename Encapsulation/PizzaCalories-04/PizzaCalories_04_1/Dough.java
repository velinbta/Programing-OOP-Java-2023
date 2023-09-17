package PizzaCalories_04_1;

import java.util.Arrays;

public class Dough {

    private enum DoughType {

        WHITE(1.5),
        WHOLEGRAIN(1.0),
        CRISPY(0.9),
        CHEWY(1.1),
        HOMEMADE(1.0);

        private final double modifier;

        DoughType(double modifier) {
            this.modifier = modifier;
        }

        public static boolean containsIgnoreCase(String type) { // <- check if enum exists
            return Arrays.stream(DoughType.values()).map(String::valueOf)
                    .anyMatch(dough -> dough.equalsIgnoreCase(type));
        }

        public static DoughType parse(String type) { // <- parse enum from String
            type = type.toUpperCase();

            switch (type) {

                case "WHITE":
                    return WHITE;
                case "WHOLEGRAIN":
                    return WHOLEGRAIN;
                case "CRISPY":
                    return CRISPY;
                case "CHEWY":
                    return CHEWY;
                case "HOMEMADE":
                    return HOMEMADE;

            }
            throw new IllegalArgumentException(String.format("Type not found: %s", type));
        }

    }

    private static final double BASE_CALORIES_PER_GRAM = 2D;

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        ensureType(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        ensureType(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) // <- range
            throw stateException("Dough weight should be in the range [1..200].");
        this.weight = weight;
    }

    public double calculateCalories() {
        return (BASE_CALORIES_PER_GRAM * this.weight) * DoughType.parse(this.flourType).modifier *
                DoughType.parse(this.bakingTechnique).modifier;
    }

    private IllegalStateException stateException(String message) {
        throw new IllegalStateException(message);
    }

    private void ensureType(String type) { // <- if unknown enum
        if (!DoughType.containsIgnoreCase(type))
            throw stateException("Invalid type of dough.");
    }

}
