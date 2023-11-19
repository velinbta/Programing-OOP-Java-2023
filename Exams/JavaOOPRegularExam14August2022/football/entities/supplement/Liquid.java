package football.entities.supplement;

public class Liquid extends BaseSupplement {

    private static final int INITIAL_ENERGY = 90;
    private static final double INITIAL_PRICE = 25D;

    public Liquid() {
        super(INITIAL_ENERGY, INITIAL_PRICE);
    }

}
