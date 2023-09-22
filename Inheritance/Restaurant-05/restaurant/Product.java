package restaurant;

import java.math.BigDecimal;

public class Product {

    private static long ctorCounter;

    private final String name;
    private final BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        ctorCounter++;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public static long getCtorCounter() {
        return ctorCounter;
    }

}
