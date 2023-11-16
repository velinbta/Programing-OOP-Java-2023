package christmasPastryShop.entities.delicacies;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.Objects;

public abstract class BaseDelicacy implements Delicacy {

    private String name;
    private double portion;
    private double price;

    protected BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if (this.isLessOrEqualToZero(portion)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }


    private void setPrice(double price) {
        if (this.isLessOrEqualToZero(price)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
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
        return value <= 0;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f", this.getName(), this.getPortion(), this.getPrice());
    }

}
