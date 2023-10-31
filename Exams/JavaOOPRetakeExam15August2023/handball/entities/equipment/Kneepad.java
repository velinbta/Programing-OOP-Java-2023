package handball.entities.equipment;

public class Kneepad extends BaseEquipment {

    private final static int DEFAULT_KNEEPAD_PROTECTION = 120;
    private final static double DEFAULT_KNEEPAD_PRICE = 15D;

    public Kneepad() {
        super(DEFAULT_KNEEPAD_PROTECTION, DEFAULT_KNEEPAD_PRICE);
    }

}
