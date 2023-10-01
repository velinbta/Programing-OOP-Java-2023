package WildFarm_04_1;

public class Mouse extends Mammal {

    public Mouse(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public String rejectFood() {
        return "Mice are not eating that type of food!";
    }

    @Override
    public boolean eat(Food food) {
        if (!Food.FoodType.isVegetable(food.getClass().getSimpleName()))
            return false;

        this.addFood(food.getQuantity());
        return true;
    }

}
