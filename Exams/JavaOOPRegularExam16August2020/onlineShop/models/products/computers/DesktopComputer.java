package onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer {

    private static final double DEFAULT_OVERALL_PERFORMANCE = 15D;

    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, DEFAULT_OVERALL_PERFORMANCE);
    }

}
