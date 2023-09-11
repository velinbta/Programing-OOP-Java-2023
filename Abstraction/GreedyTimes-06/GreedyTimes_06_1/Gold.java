package GreedyTimes_06_1;

// Static class Gem
public class Gold {

    private static long totalAmount;

    private Gold() {
        // Don't let anyone instantiate an instance of this class
    }

    public static void add(long amount) {
        totalAmount += amount;
    }

    public static long getTotalAmount() {
        return totalAmount;
    }

    public static String getInfo() {
        return String.format("##Gold - %d", Gold.getTotalAmount());
    }

}
