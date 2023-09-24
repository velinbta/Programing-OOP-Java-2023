package CarShopExtend_02_1;

public class Audi extends CarImpl implements Rentable {

    private final Integer minRentDay;
    private final Double pricePerDay;

    public Audi(String model, String color, Integer horsepower, String countryProduced,
                Integer minRentDay, Double pricePerDay) {
        super(model, color, horsepower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    @SuppressWarnings({"all"})
    public String toString() {
        // More info appended
        StringBuilder audi = new StringBuilder();
        audi.append(super.toString());

        audi.append(System.lineSeparator());
        audi.append(String.format("Minimum rental period of %d days. Price per day %f", this.getMinRentDay(),
                this.getPricePerDay()));

        return audi.toString().trim();
    }

}
