package restaurant.entity.food;

public class VeganBiscuits extends Food {

    private static final double INITIAL_PORTION = 205D;

    public VeganBiscuits(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }

}
