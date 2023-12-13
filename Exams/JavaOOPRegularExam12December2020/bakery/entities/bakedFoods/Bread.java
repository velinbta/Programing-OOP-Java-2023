package bakery.entities.bakedFoods;

public class Bread extends BaseFood {

    private static final double INITIAL_PORTION = 200D;

    public Bread(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }

}
