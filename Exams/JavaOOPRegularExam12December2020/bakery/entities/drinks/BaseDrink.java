package bakery.entities.drinks;

import bakery.common.ExceptionMessage;

import java.util.Objects;

public abstract class BaseDrink implements Drink {

    private String name;
    private int portion;
    private double price;
    private String brand;

    protected BaseDrink(String name, int portion, double price, String brand) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
        this.setBrand(brand);
    }

    private void setName(String name) {
        if (this.isNullOrWhitespace(name)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(int portion) {
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

    private void setBrand(String brand) {
        if (this.isNullOrWhitespace(brand)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRAND);
        }
        this.brand = brand;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private boolean isNullOrWhitespace(String value) {
        return Objects.isNull(value) || value.isBlank();
    }

    private boolean isLessOrEqualToZero(int value) {
        return value <= 0;
    }

    private boolean isLessOrEqualToZero(double value) {
        return value <= 0D;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %dml - %.2flv", this.getName(), this.getBrand(),
                this.getPortion(), this.getPrice());
    }

}
