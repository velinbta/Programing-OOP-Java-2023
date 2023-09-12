package GreedyTimes_06_2;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Gem extends Item { // <- Вид Item

    private final Map<String, Long> itemAmount;

    public Gem() {
        this.itemAmount = new LinkedHashMap<>();
    }

    @Override
    public void add(String item, long amount) {
        this.itemAmount.putIfAbsent(item, 0L);
        this.itemAmount.put(item, this.itemAmount.get(item) + amount);
    }

    @Override
    public long getTotalAmount() {
        return this.itemAmount.values().stream().mapToLong(n -> n).sum();
    }

    @Override
    public String toString() {

        StringBuilder gem = new StringBuilder();

        // По намаляващ азбучен ред
        this.itemAmount.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
                forEach(v -> {

                    gem.append(String.format("##%s - %d", v.getKey(), v.getValue()));
                    gem.append(System.lineSeparator());

                });

        return gem.toString().trim();

    }

}