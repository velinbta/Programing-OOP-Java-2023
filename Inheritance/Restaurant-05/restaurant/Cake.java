package restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {

    private static final BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);
    private static final double CAKE_GRAMS = 250D;
    private static final double CAKE_CALORIES = 1000D;

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }

}
