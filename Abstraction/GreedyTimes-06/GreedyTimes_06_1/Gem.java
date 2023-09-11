package GreedyTimes_06_1;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

// Static class Gem
public class Gem {

    private static long totalAmount;
    private static final Map<String, Long> itemAmount = new LinkedHashMap<>();

    private Gem() {
        // Don't let anyone instantiate an instance of this class
    }

    public static void add(String item, long amount) {

        itemAmount.putIfAbsent(item, 0L);
        itemAmount.put(item, itemAmount.get(item) + amount);

        totalAmount += amount;
    }

    public static long getTotalAmount() {
        return totalAmount;
    }

    public static String getInfo() {

        StringBuilder gem = new StringBuilder();

        // По намаляващ азбучен ред
        itemAmount.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
                forEach(v -> {

                    gem.append(String.format("##%s - %d", v.getKey(), v.getValue()));
                    gem.append(System.lineSeparator());

                });

        return gem.toString().trim();
    }

}
