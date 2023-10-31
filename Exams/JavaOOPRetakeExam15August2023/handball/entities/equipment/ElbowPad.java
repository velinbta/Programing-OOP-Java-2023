package handball.entities.equipment;

public class ElbowPad extends BaseEquipment {

    private final static int DEFAULT_ELBOWPAD_PROTECTION = 90;
    private final static double DEFAULT_ELBOWPAD_PRICE = 25D;

    public ElbowPad() {
        super(DEFAULT_ELBOWPAD_PROTECTION, DEFAULT_ELBOWPAD_PRICE);
    }

}
