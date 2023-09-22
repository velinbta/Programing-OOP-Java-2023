package restaurant;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // No specific task presented

        IntStream.range(0, 900).forEach(n -> {
            Cake cake = new Cake("Garaj");
        });
        IntStream.range(0, 100).forEach(n -> {
            Cake cake = new Cake("Garaj");
        });

        IntStream.range(0, 900).forEach(n -> {
            Coffee coffee = new Coffee("Cappuccino", 0D);
        });
        IntStream.range(0, 100).forEach(n -> {
            Coffee coffee = new Coffee("Cappuccino", 0D);
        });

        System.out.printf("Product' ctor has been called %d time/s.", Product.getCtorCounter());

    }

}
