package GreedyTimes_06_1;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

// Static class Gem
public class Cash {

    private static long totalAmount;
    private static final Map<String, Long> itemAmount = new LinkedHashMap<>();

    private Cash() {
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

        StringBuilder cash = new StringBuilder();

        // По намаляващ азбучен ред
        itemAmount.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
                forEach(v -> {

                    cash.append(String.format("##%s - %d", v.getKey(), v.getValue()));
                    cash.append(System.lineSeparator());

                });

        return cash.toString().trim();
    }

}
