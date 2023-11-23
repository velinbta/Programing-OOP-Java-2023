package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessage;
import glacialExpedition.common.ExceptionMessage;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseExplorer implements Explorer {

    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    @Override
    public void search() {
        double decreasedEnergy = this.getEnergy() - 15;
        this.setEnergy(Math.max(decreasedEnergy, 0));
    }

    @Override
    public boolean canSearch() {
        return this.getEnergy() > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessage.EXPLORER_ENERGY_LESS_THAN_ZERO);
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
    public String toString() {

        StringBuilder explorer = new StringBuilder();

        explorer.append(String.format(ConstantMessage.FINAL_EXPLORER_NAME_FORMAT, this.getName()));
        explorer.append(System.lineSeparator());

        explorer.append(String.format(ConstantMessage.FINAL_EXPLORER_ENERGY_FORMAT, this.getEnergy()));
        explorer.append(System.lineSeparator());

        String suitcaseExhibitsInfo = this.suitcase.getExhibits().isEmpty()
                ? String.format(ConstantMessage.FINAL_EXPLORER_SUITCASE_EXHIBITS_FORMAT, "None")
                : String.format(ConstantMessage.FINAL_EXPLORER_SUITCASE_EXHIBITS_FORMAT,
                String.join(ConstantMessage.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, this.suitcase.getExhibits()));

        explorer.append(suitcaseExhibitsInfo);

        return explorer.toString().trim();
    }

}
