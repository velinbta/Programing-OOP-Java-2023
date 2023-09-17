package PizzaCalories_04_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pizza {

    private String name;
    private Dough dough;
    private final List<Topping> toppings;

    // Unknown reason for numberOfToppings existence
    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setToppings(int toppings) {
        if (toppings < 0 || toppings > 10) // <- range
            throw stateException("Number of toppings should be in range [0..10].");
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank() || name.length() > 15) // <- range
            throw stateException("Pizza name should be between 1 and 15 symbols.");
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        if (Objects.isNull(this.dough))
            throw stateException("Dough must be set.");

        // All toppings calories total
        double toppingsCalories = this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();

        return this.dough.calculateCalories() + toppingsCalories;
    }

    public String getName() {
        return this.name;
    }

    private IllegalStateException stateException(String message) {
        return new IllegalStateException(message);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getOverallCalories());
    }

}
