package ShoppingSpree_03_1;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        Validator.validateName(name); // <- Not null or blank
        this.name = name;
    }

    private void setCost(double cost) {
        Validator.validateMoney(cost); // <- Not negative
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
