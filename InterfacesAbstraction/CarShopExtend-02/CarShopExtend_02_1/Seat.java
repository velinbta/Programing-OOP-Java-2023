package CarShopExtend_02_1;

public class Seat extends CarImpl implements Sellable {

    private final Double price;

    public Seat(String model, String color, Integer horsepower, String countryProduced, Double price) {
        super(model, color, horsepower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    @SuppressWarnings({"all"})
    public String toString() {
        // More info appended
        StringBuilder seat = new StringBuilder();
        seat.append(super.toString());

        seat.append(System.lineSeparator());
        seat.append(String.format("%s sells for %f", this.getModel(), this.getPrice()));

        return seat.toString().trim();
    }

}
