package fairyShop.models;

import fairyShop.common.ExceptionMessages;

import java.util.Objects;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        this.setName(name);
        this.setEnergyRequired(energyRequired);
    }

    @Override
    public void getCrafted() {
        int decreasedEnergyRequired = this.getEnergyRequired() - 10;
        this.setEnergyRequired(Math.max(decreasedEnergyRequired, 0));
    }

    @Override
    public boolean isDone() {
        return this.getEnergyRequired() == 0;
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

}
