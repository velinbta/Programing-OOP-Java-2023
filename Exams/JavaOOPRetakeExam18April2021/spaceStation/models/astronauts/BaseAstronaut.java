package spaceStation.models.astronauts;

import spaceStation.common.ConstantMessage;
import spaceStation.common.ExceptionMessage;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseAstronaut implements Astronaut {

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public boolean canBreath() {
        return this.getOxygen() > 0D;
    }

    @Override
    public void breath() {
        double decreasedOxygen = this.getOxygen() - 10D;
        this.setOxygen(Math.max(decreasedOxygen, 0D));
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0D) {
            throw new IllegalArgumentException(ExceptionMessage.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
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
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public String toString() {

        StringBuilder astronaut = new StringBuilder();

        astronaut.append(String.format(ConstantMessage.REPORT_ASTRONAUT_NAME_FORMAT, this.getName())).
                append(System.lineSeparator());
        astronaut.append(String.format(ConstantMessage.REPORT_ASTRONAUT_OXYGEN_FORMAT, this.getOxygen())).
                append(System.lineSeparator());

        String bagInfo = this.bag.getItems().isEmpty()
                ? String.format(ConstantMessage.REPORT_ASTRONAUT_BAG_ITEMS_FORMAT, "none")
                : String.format(ConstantMessage.REPORT_ASTRONAUT_BAG_ITEMS_FORMAT,
                String.join(ConstantMessage.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, this.bag.getItems()));

        astronaut.append(bagInfo);

        return astronaut.toString().trim();
    }

}
