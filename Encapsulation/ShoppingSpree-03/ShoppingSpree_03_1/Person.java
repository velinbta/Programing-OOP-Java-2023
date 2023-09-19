package ShoppingSpree_03_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name); // <- Not null or blank
        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateMoney(money); // <- Not negative
        this.money = money;
    }

    public void buyProduct(Product product) {

        double result = this.getMoney() - product.getCost();

        if (result < 0D) { // <- Does not have enough money
            throw new IllegalStateException(String.format("%s can't afford %s", this.getName(), product));
        }

        this.setMoney(result);
        this.products.add(product);

    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    @Override
    public String toString() {

        StringBuilder person = new StringBuilder();

        person.append(String.format("%s - ", this.getName()));
        if (this.products.isEmpty()) {
            person.append("Nothing bought");
            return person.toString().trim();
        }

        person.append(this.products.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));

        return person.toString().trim();
    }

}
