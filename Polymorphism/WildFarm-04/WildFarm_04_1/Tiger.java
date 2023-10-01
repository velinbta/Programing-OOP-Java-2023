package WildFarm_04_1;

public class Tiger extends Feline {

    public Tiger(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public boolean eat(Food food) {
        if (!Food.FoodType.isMeat(food.getClass().getSimpleName()))
            return false;

        this.addFood(food.getQuantity());
        return true;
    }

}
