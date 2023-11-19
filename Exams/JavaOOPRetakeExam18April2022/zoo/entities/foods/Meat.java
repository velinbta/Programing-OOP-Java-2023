package zoo.entities.foods;

public class Meat extends BaseFood {

    private static final int CALORIES = 70;
    private static final double PRICE = 10D;

    public Meat() {
        super(CALORIES, PRICE);
    }

}
