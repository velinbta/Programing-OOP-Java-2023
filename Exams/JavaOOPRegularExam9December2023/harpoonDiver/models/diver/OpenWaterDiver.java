package harpoonDiver.models.diver;

public class OpenWaterDiver extends BaseDiver {

    private static final double INITIAL_OXYGEN = 30D;

    public OpenWaterDiver(String name) {
        super(name, INITIAL_OXYGEN);
    }

}
