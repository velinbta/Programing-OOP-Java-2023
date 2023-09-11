package GreedyTimes_06_1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Treasure {

    private final long bagCapacity;

    private final Map<String, Long> typeTotal;

    public Treasure(long bagCapacity) {
        this.bagCapacity = bagCapacity;
        this.typeTotal = new LinkedHashMap<>();
    }

    public boolean add(String item, long amount) {

        if (!TypeTreasure.isValuable(item) || !this.isInBoundsOfBagCapacity(amount))
            return false; // <- Ако не е "ценен" или надхвърля капацитета

        TypeTreasure type = TypeTreasure.parse(item);

        switch (type) {
            case GOLD:
                return this.addGold(amount);
            case CASH:
                return this.addCash(item, amount);
            case GEM:
                return this.addGem(item, amount);
        }

        return false;
    }

    private boolean addGold(long amount) {
        // The gold amount should always be more than or equal to the gem amount at any time
        boolean canAdd = Gold.getTotalAmount() + amount >= Gem.getTotalAmount();

        if (canAdd) {
            this.treasureAdd("Gold", amount);
            Gold.add(amount);
        }

        return canAdd;
    }

    private boolean addCash(String item, long amount) {
        // The gem amount should always be more than or equal to the cash amount at any time
        boolean canAdd = Gem.getTotalAmount() >= Cash.getTotalAmount() + amount;

        if (canAdd) {
            this.treasureAdd("Cash", amount);
            Cash.add(item, amount);
        }

        return canAdd;
    }

    private boolean addGem(String item, long amount) {
        // The gold amount should always be more than or equal to the gem amount at any time
        // The gem amount should always be more than or equal to the cash amount at any time

        long gemTotal = Gem.getTotalAmount() + amount;
        boolean canAdd = Gold.getTotalAmount() >= gemTotal && gemTotal >= Cash.getTotalAmount();

        if (canAdd) {
            this.treasureAdd("Gem", amount);
            Gem.add(item, amount);
        }

        return canAdd;
    }

    private boolean isInBoundsOfBagCapacity(long amount) {
        return Gold.getTotalAmount() + Cash.getTotalAmount() + Gem.getTotalAmount() + amount <= this.bagCapacity;
    }

    private void treasureAdd(String item, long amount) {
        this.typeTotal.putIfAbsent(item, 0L);
        this.typeTotal.put(item, this.typeTotal.get(item) + amount);
    }

    @Override
    public String toString() {
        // Summary
        StringBuilder treasure = new StringBuilder();

        this.typeTotal.forEach((type, value) -> {

            switch (type) {

                case "Gold":

                    treasure.append(String.format("<%s> $%d", type, value));
                    treasure.append(System.lineSeparator());
                    treasure.append(Gold.getInfo());
                    treasure.append(System.lineSeparator());

                    break;

                case "Cash":

                    treasure.append(String.format("<%s> $%d", type, value));
                    treasure.append(System.lineSeparator());
                    treasure.append(Cash.getInfo());
                    treasure.append(System.lineSeparator());

                    break;

                case "Gem":

                    treasure.append(String.format("<%s> $%d", type, value));
                    treasure.append(System.lineSeparator());
                    treasure.append(Gem.getInfo());
                    treasure.append(System.lineSeparator());

                    break;

            }

        });

        return treasure.toString().trim();

    }

}
