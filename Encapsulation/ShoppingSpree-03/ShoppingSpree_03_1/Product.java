package ShoppingSpree_03_1;

import java.util.Objects;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        // Not null or blank
        if (Objects.isNull(name) || name.isBlank())
            throw stateException("Name cannot be empty");
        this.name = name;
    }

    private void setCost(double cost) {
        // Not negative
        if (cost < 0D)
            throw stateException("Money cannot be negative");
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    private IllegalStateException stateException(String message) {
        throw new IllegalStateException(message);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
