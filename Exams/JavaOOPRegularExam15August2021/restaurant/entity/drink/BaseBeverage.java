package restaurant.entity.drink;

import restaurant.common.ExceptionMessage;

import java.util.Objects;

public abstract class BaseBeverage implements Beverages {

    private String name;
    private int counter;
    private double price;
    private String brand;

    protected BaseBeverage(String name, int counter, double price, String brand) {
        this.setName(name);
        this.setCounter(counter);
        this.setPrice(price);
        this.setBrand(brand);
    }

    private void setName(String name) {
        if (this.isNullOrWhitespace(name)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NAME);
        }
        this.name = name;
    }

    private void setCounter(int counter) {
        if (this.isLessOrEqualToZero(counter)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COUNTER);
        }
        this.counter = counter;
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
    public int getCounter() {
        return this.counter;
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

}
