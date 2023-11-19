package zoo.entities.animals;

import zoo.common.ExceptionMessages;

import java.util.Objects;

public abstract class BaseAnimal implements Animal {

    private String name;
    private String kind;
    private double kg;
    private double price;

    protected BaseAnimal(String name, String kind, double kg, double price) {
        this.setName(name);
        this.setKind(kind);
        this.setKg(kg);
        this.setPrice(price);
    }

    @Override
    public abstract void eat();

    private void setName(String name) {
        if (this.isNullOrWhitespace(name)) {
            throw new NullPointerException(ExceptionMessages.ANIMAL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setKind(String kind) {
        if (this.isNullOrWhitespace(kind)) {
            throw new NullPointerException(ExceptionMessages.ANIMAL_KIND_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private boolean isNullOrWhitespace(String value) {
        return Objects.isNull(value) || value.isBlank();
    }

}
