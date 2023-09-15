package AnimalFarm_02_1;

import java.util.Objects;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) // <- not null, or blank
            throw stateException("Name cannot be empty.");
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15)
            throw stateException("Age should be between 0 and 15.");
        this.age = age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.age < 6)
            return 2D;
        if (this.age < 12)
            return 1D;
        return 0.75;
    }

    private IllegalStateException stateException(String message) {
        throw new IllegalStateException(message);
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name,
                this.age, this.productPerDay());
    }

}
