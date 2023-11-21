package fairyShop.models;

import fairyShop.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseHelper implements Helper {

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    @Override
    public void work() {
        int decreasedEnergy = this.getEnergy() - 10;
        this.setEnergy(Math.max(decreasedEnergy, 0));
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.getEnergy() > 0;
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return Collections.unmodifiableCollection(this.instruments); // TODO not mentioned ??
    }

    @Override
    public String toString() {

        StringBuilder helper = new StringBuilder();

        helper.append(String.format("Name: %s", this.getName()));
        helper.append(System.lineSeparator());

        helper.append(String.format("Energy: %d", this.getEnergy()));
        helper.append(System.lineSeparator());

        long fitInstruments = this.getInstruments().stream().filter(instrument ->
                !instrument.isBroken()).count();

        helper.append(String.format("Instruments: %d not broken left", fitInstruments));

        return helper.toString().trim();

    }

}
