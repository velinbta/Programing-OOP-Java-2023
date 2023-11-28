package restaurant.entity.food;

import restaurant.common.ExceptionMessage;

import java.util.Objects;

public abstract class Food implements HealthyFood {

    private String name;
    private double portion;
    private double price;

    protected Food(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if (this.isLessOrEqualToZero(portion)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setPrice(double price) {
        if (this.isLessOrEqualToZero(price)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private boolean isLessOrEqualToZero(double value) {
        return value <= 0D;
    }

}
