package WildFarm_04_1;

public abstract class Food {

    public enum FoodType {

        VEGETABLE,
        MEAT;

        public static boolean isFood(String foodName) {
            return isVegetable(foodName) || isMeat(foodName);
        }

        public static boolean isVegetable(String foodName) {
            return foodName.equalsIgnoreCase(VEGETABLE.name());
        }

        public static boolean isMeat(String foodName) {
            return foodName.equalsIgnoreCase(MEAT.name());
        }

    }

    private Integer quantity;

    protected Food(Integer quantity) {
        this.setQuantity(quantity);
    }

    private void setQuantity(Integer quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative: " + quantity);
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

}
