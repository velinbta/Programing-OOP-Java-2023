package christmasPastryShop.entities.cocktails;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.Objects;

public abstract class BaseCocktail implements Cocktail {

    private String name;
    private int size;
    private double price;
    private String brand;

    protected BaseCocktail(String name, int size, double price, String brand) {
        this.setName(name);
        this.setSize(size);
        this.setPrice(price);
        this.setBrand(brand);
    }

    private void setName(String name) {
        if (this.isNullOrWhitespace(name)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    private void setSize(int size) {
        if (this.isLessOrEqualToZero(size)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SIZE);
        }
        this.size = size;
    }

    private void setPrice(double price) {
        if (this.isLessOrEqualToZero(price)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    private void setBrand(String brand) {
        if (this.isNullOrWhitespace(brand)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
        }
        this.brand = brand;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
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
        return String.format("%s %s - %dml - %.2flv", this.getName(), this.getBrand(), this.getSize(), this.getPrice());
    }

}
