package GreedyTimes_06_2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Treasure {

    private static final String GOLD = "Gold";
    private static final String GEM = "Gem";
    private static final String CASH = "Cash";

    private final long bagCapacity;

    private final Map<String, Item> typeItem;

    public Treasure(long bagCapacity) {
        this.bagCapacity = bagCapacity;
        this.typeItem = new LinkedHashMap<>();
    }

    public boolean add(String item, long amount) {

        if (!this.isValuable(item) || !this.isInBoundsOfBagCapacity(amount)) {
            return false;
        }

        String type = getType(item);

        if (!typeIsBalanced(type, amount))
            return false;

        this.typeItemAdd(type, item, amount);

        return true;
    }

    private void typeItemAdd(String type, String item, long amount) {

        this.typeItem.putIfAbsent(type, Item.parse(type)); // <- adds new object of Item if absent
        this.typeItem.get(type).add(item, amount); // <- adds new items on the specific type

    }

    private boolean typeIsBalanced(String type, long amount) {

        long goldTotal = getTypeTotal(GOLD);
        long gemTotal = getTypeTotal(GEM);
        long cashTotal = getTypeTotal(CASH);

        switch (type) {

            case GOLD:
                // The gold amount should always be more than or equal to the gem amount at any time
                return goldTotal + amount >= gemTotal;
            case CASH:
                // The gem amount should always be more than or equal to the cash amount at any time
                return gemTotal >= cashTotal + amount;
            case GEM:
                // The gold amount should always be more than or equal to the gem amount at any time
                // The gem amount should always be more than or equal to the cash amount at any time
                return goldTotal >= gemTotal + amount && gemTotal + amount >= cashTotal;
            default:
                return false;

        }

    }

    public long getTypeTotal(String type) { // <- By specific type

        return this.typeItem.get(type) != null
                ? this.typeItem.get(type).getTotalAmount()
                : 0L;

    }

    public long getTypeTotal() { // <- All values total
        return this.getTypeTotal(CASH) + this.getTypeTotal(GEM) + this.getTypeTotal(GOLD);
    }

    private String getType(String item) { // <- Based on properties

        if (this.isGold(item))
            return GOLD;

        if (this.isCash(item))
            return CASH;

        if (this.isGem(item))
            return GEM;

        return null;
    }

    public boolean isValuable(String item) {
        return isCash(item) || isGem(item) || isGold(item);
    }

    public boolean isGold(String item) {
        return item.equalsIgnoreCase("gold");
    }

    public boolean isGem(String item) {
        return item.length() >= 4 && item.toLowerCase().endsWith("gem");
    }

    public boolean isCash(String item) {
        return item.matches("^[a-zA-Z]{3}$");
    }

    public boolean isInBoundsOfBagCapacity(long amount) {
        return this.getTypeTotal() + amount <= this.bagCapacity;
    }

    @Override
    public String toString() {

        StringBuilder treasure = new StringBuilder();

        this.typeItem.forEach((type, item) -> {

            switch (type) {

                case GOLD:

                    treasure.append(String.format("<%s> $%d", GOLD, item.getTotalAmount()));
                    treasure.append(System.lineSeparator());
                    treasure.append(item);
                    treasure.append(System.lineSeparator());

                    break;

                case CASH:

                    treasure.append(String.format("<%s> $%d", CASH, item.getTotalAmount()));
                    treasure.append(System.lineSeparator());
                    treasure.append(item);
                    treasure.append(System.lineSeparator());

                    break;

                case GEM:

                    treasure.append(String.format("<%s> $%d", GEM, item.getTotalAmount()));
                    treasure.append(System.lineSeparator());
                    treasure.append(item);
                    treasure.append(System.lineSeparator());

                    break;

            }

        });

        return treasure.toString().trim();

    }

}
