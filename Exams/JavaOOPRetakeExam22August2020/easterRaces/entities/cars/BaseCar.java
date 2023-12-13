package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessage;

import java.util.Objects;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimeters;
    private int minHorsePower;
    private int maxHorsePower;

    protected BaseCar(String model, int horsePower, double cubicCentimeters, int minHorsePower, int maxHorsePower) {
        this.setModel(model);
        this.setMinHorsePower(minHorsePower);
        this.setMaxHorsePower(maxHorsePower);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    @Override
    public double calculateRacePoints(int laps) {
        return (this.getCubicCentimeters() / this.getHorsePower()) * laps;
    }

    private void setModel(String model) {
        if (Objects.isNull(model) || model.isBlank() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_MODEL_FORMAT,
                    model, 4));
        }
        this.model = model;
    }

    private void setMinHorsePower(int minHorsePower) {
        this.minHorsePower = minHorsePower;
    }

    private void setMaxHorsePower(int maxHorsePower) {
        this.maxHorsePower = maxHorsePower;
    }

    private void setHorsePower(int horsePower) {
        if (horsePower < this.minHorsePower || horsePower > this.maxHorsePower) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_HORSE_POWER_FORMAT,
                    horsePower));
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

}
