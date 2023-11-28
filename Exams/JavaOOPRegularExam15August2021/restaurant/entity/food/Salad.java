package restaurant.entity.food;

public class Salad extends Food {

    private static final double INITIAL_PORTION = 150D;

    public Salad(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }

}
