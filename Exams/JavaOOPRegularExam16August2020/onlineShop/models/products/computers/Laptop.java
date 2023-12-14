package onlineShop.models.products.computers;

public class Laptop extends BaseComputer {

    private static final double DEFAULT_OVERALL_PERFORMANCE = 10D;

    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, DEFAULT_OVERALL_PERFORMANCE);
    }

}
