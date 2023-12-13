package bakery.entities.bakedFoods;

public class Cake extends BaseFood {

    private static final double INITIAL_PORTION = 245D;

    public Cake(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }

}
