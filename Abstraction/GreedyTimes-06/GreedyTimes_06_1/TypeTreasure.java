package GreedyTimes_06_1;

// enum types of treasure
public enum TypeTreasure {

    GOLD,
    GEM,
    CASH;

    public static TypeTreasure parse(String item) {

        if (isGold(item))
            return GOLD;

        if (isGem(item))
            return GEM;

        if (isCash(item))
            return CASH;

        throw new IllegalArgumentException("Useless item " + item);

    }

    public static boolean isValuable(String item) {
        return isCash(item) || isGem(item) || isGold(item);
    }

    private static boolean isGold(String item) {
        return item.equalsIgnoreCase("gold");
    }

    private static boolean isGem(String item) {
        return item.length() >= 4 && item.toLowerCase().endsWith("gem");
    }

    private static boolean isCash(String item) {
        return item.matches("^[a-zA-Z]{3}$");
    }

}
