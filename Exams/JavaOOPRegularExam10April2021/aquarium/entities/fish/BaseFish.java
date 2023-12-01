package aquarium.entities.fish;

import aquarium.common.ExceptionMessage;

import java.util.Objects;

public abstract class BaseFish implements Fish {

    private String name;
    private String species;
    private int size;
    private double price;

    protected BaseFish(String name, String species, double price, int size) {
        this.setName(name);
        this.setSpecies(species);
        this.setPrice(price);
        this.setSize(size);
    }

    @Override
    public void eat() {
        this.setSize(this.getSize() + 5);
    }

    @Override
    public void setName(String name) {
        if (this.isNullOrWhitespace(name)) {
            throw new NullPointerException(ExceptionMessage.FISH_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setSpecies(String species) {
        if (this.isNullOrWhitespace(species)) {
            throw new NullPointerException(ExceptionMessage.SPECIES_NAME_NULL_OR_EMPTY);
        }
        this.species = species;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    protected void setSize(int size) {
        this.size = size;
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

    private boolean isNullOrWhitespace(String value) {
        return Objects.isNull(value) || value.isBlank();
    }

}
