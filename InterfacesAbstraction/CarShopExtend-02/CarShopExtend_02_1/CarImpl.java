package CarShopExtend_02_1;

// Car interface implementation as a simple data holder
// Wrapper required
public class CarImpl implements Car {

    private final String model;
    private final String color;
    private final Integer horsepower;
    private final String countryProduced;

    protected CarImpl(String model, String color, Integer horsepower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsepower;
    }

    @Override
    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    @SuppressWarnings({"all"})
    public String toString() {

        StringBuilder output = new StringBuilder();

        // Typo in task given input - <have> must be <has>
        // Typo in task given input - <horse power> should be <horsepower>
        output.append(String.format("%s is %s color and have %s horse power", this.getModel(), this.getColor(),
                this.getHorsePower()));

        output.append(System.lineSeparator());

        output.append(String.format("This is %s produced in %s and have %d tires", this.getModel(),
                this.getCountryProduced(), Car.TIRES));

        return output.toString().trim();
    }

}
