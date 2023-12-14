package onlineShop.models.products;

import onlineShop.common.ExceptionMessage;
import onlineShop.common.OutputMessage;

import java.util.Objects;

public abstract class BaseProduct implements Product {

    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    protected BaseProduct(int id, String manufacturer, String model,
                          double price, double overallPerformance) {
        this.setId(id);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setOverallPerformance(overallPerformance);
    }

    private void setId(int id) {
        if (this.isLessOrEqualToZero(id)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_ID);
        }
        this.id = id;
    }

    private void setManufacturer(String manufacturer) {
        if (this.isNullorWhitespace(manufacturer)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
    }

    private void setModel(String model) {
        if (this.isNullorWhitespace(model)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MODEL);
        }
        this.model = model;
    }

    private void setPrice(double price) {
        if (this.isLessOrEqualToZero(price)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRICE);
        }
        this.price = price;
    }

    private void setOverallPerformance(double overallPerformance) {
        if (this.isLessOrEqualToZero(overallPerformance)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getOverallPerformance() {
        return this.overallPerformance;
    }

    private boolean isNullorWhitespace(String value) {
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
        return String.format(OutputMessage.PRODUCT_TO_STRING_FORMAT, this.getOverallPerformance(), this.getPrice(),
                this.getClass().getSimpleName(), this.getManufacturer(), this.getModel(), this.getId());
    }

}
