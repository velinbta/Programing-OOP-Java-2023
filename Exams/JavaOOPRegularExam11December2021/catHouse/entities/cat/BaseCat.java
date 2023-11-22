package catHouse.entities.cat;

import catHouse.common.ExceptionMessage;

import java.util.Objects;

public abstract class BaseCat implements Cat {

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    protected BaseCat(String name, String breed, double price, int kilograms) {
        this.setName(name);
        this.setBreed(breed);
        this.setKilograms(kilograms);
        this.setPrice(price);
    }

    @Override
    public abstract void eating();

    @Override
    public void setName(String name) {
        if (this.isNullOrWhitespace(name)) {
            throw new NullPointerException(ExceptionMessage.CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setBreed(String breed) {
        if (this.isNullOrWhitespace(breed)) {
            throw new NullPointerException(ExceptionMessage.CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.breed = breed;
    }

    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private boolean isNullOrWhitespace(String value) {
        return Objects.isNull(value) || value.isBlank();
    }

}
