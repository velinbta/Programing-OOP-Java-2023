package harpoonDiver.models.diver;

import harpoonDiver.common.ConstantMessage;
import harpoonDiver.common.ExceptionMessage;
import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseDiver implements Diver {

    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    protected BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0D) {
            throw new IllegalArgumentException(ExceptionMessage.DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public void shoot() {
        double decreasedOxygen = this.getOxygen() - 30D;
        this.setOxygen(Math.max(decreasedOxygen, 0D));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canDive() {
        return this.getOxygen() > 0D;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return this.seaCatch;
    }

    @Override
    public String toString() {

        StringBuilder diverToString = new StringBuilder();

        diverToString.append(String.format(ConstantMessage.FINAL_DIVER_NAME_FORMAT, this.getName())).
                append(System.lineSeparator());

        diverToString.append(String.format(ConstantMessage.FINAL_DIVER_OXYGEN_FORMAT, this.getOxygen())).
                append(System.lineSeparator());

        String diversCatch = this.seaCatch.getSeaCreatures().isEmpty()
                ? String.format(ConstantMessage.FINAL_DIVER_CATCH_FORMAT, "None")
                : String.format(ConstantMessage.FINAL_DIVER_CATCH_FORMAT,
                String.join(ConstantMessage.FINAL_DIVER_CATCH_DELIMITER, this.seaCatch.getSeaCreatures()));

        diverToString.append(diversCatch);

        return diverToString.toString().trim();
    }

}
