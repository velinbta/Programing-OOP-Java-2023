package WildFarm_04_1;

public class Zebra extends Mammal {

    public Zebra(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    public boolean eat(Food food) {
        if (!Food.FoodType.isVegetable(food.getClass().getSimpleName()))
            return false;

        this.addFood(food.getQuantity());
        return true;
    }

}
