package goldDigger.models.discoverer;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if (energy < 0D) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        return this.getEnergy() > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {

        double energyLeft = this.getEnergy() - 15D;

        this.setEnergy(Math.max(energyLeft, 0D));

    }

    @Override
    public String toString() {

        StringBuilder discoverer = new StringBuilder();

        discoverer.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, this.getName()));
        discoverer.append(System.lineSeparator());

        discoverer.append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, this.getEnergy()));
        discoverer.append(System.lineSeparator());

        String museumsOutput = this.getMuseum().getExhibits().isEmpty()
                ? String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None")
                : String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,
                        this.getMuseum().getExhibits()));

        discoverer.append(museumsOutput);

        return discoverer.toString().trim();
    }

}
