package fairyShop.models;

public class Sleepy extends BaseHelper {

    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        int decreasedEnergy = this.getEnergy() - 15;
        this.setEnergy(Math.max(decreasedEnergy, 0));
    }

}
