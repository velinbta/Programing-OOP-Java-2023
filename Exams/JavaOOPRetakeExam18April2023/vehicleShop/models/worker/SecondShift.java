package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {

    private static final int INITIAL_STRENGTH = 70;

    public SecondShift(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void working() {

        int workStrength = this.getStrength() - 15;

        try {
            this.setStrength(workStrength);
        } catch (IllegalArgumentException e) {
            this.setStrength(0);
        }

    }

}
