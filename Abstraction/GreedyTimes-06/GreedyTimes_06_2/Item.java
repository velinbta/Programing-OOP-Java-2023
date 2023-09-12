package GreedyTimes_06_2;

// Implement two abstract methods
public abstract class Item {

    public abstract void add(String item, long amount);

    public abstract long getTotalAmount();

    // New Instance of the possible ones
    public static Item parse(String type) {

        switch (type) {

            case "Gold":
                return new Gold();

            case "Gem":
                return new Gem();

            case "Cash":
                return new Cash();

            default:
                throw new IllegalArgumentException("Unknown type " + type);

        }

    }

}

