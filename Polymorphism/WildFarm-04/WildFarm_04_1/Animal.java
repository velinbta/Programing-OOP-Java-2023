package WildFarm_04_1;

public abstract class Animal {

    private final String name;
    private final String type;
    private final Double weight;

    private Integer foodEaten;

    protected Animal(String name, String type, Double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public abstract String makeSound();

    public abstract boolean eat(Food food);

    public String rejectFood() {
        return String.format("%ss are not eating that type of food!", this.getType());
    }

    protected void addFood(Integer quantity) {
        this.foodEaten += quantity;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public Double getWeight() {
        return this.weight;
    }

    public Integer getFoodEaten() {
        return this.foodEaten;
    }

}
