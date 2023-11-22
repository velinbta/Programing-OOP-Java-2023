package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

import java.util.Objects;

public abstract class BaseCar implements Car {

    private int minimumHorsePower;
    private int maximumHorsePower;

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters,
                      int minimumHorsePower, int maximumHorsePower) {
        this.setMinimumHorsePower(minimumHorsePower);
        this.setMaximumHorsePower(maximumHorsePower);
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    private void setMinimumHorsePower(int minimumHorsePower) { // TODO
        this.minimumHorsePower = minimumHorsePower;
    }

    private void setMaximumHorsePower(int maximumHorsePower) { // TODO
        this.maximumHorsePower = maximumHorsePower;
    }

    private void setModel(String model) {
        if (Objects.isNull(model) || model.isBlank() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL_FORMAT,
                    this.getModel(), 4));
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        if (horsePower < this.minimumHorsePower || horsePower > this.maximumHorsePower) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER_FORMAT, horsePower));
        }
        this.horsePower = horsePower;
    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return (this.getCubicCentimeters() / this.getHorsePower()) * laps;
    }

}
