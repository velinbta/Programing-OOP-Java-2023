package WildFarm_04_1;

import java.text.DecimalFormat;

public class Cat extends Feline {

    private final String breed;

    public Cat(String name, String type, Double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public boolean eat(Food food) {
        this.addFood(food.getQuantity());
        return true;
    }

    public String getBreed() {
        return this.breed;
    }

    @Override
    public String toString() {
        // Two digits after the decimal separator
        DecimalFormat df = new DecimalFormat("#.##");

        return String.format("Cat[%s, %s, %s, %s, %d]", this.getName(), this.getBreed(),
                df.format(this.getWeight()), this.getLivingRegion(), this.getFoodEaten());
    }

}
