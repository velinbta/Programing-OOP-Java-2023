package christmasPastryShop.common.enums;

import christmasPastryShop.common.ExceptionMessages;

public enum CocktailType {

    MULLED_WINE,
    HIBERNATION;

    public static CocktailType parseCocktail(String cocktailAsString) {

        switch (cocktailAsString) {

            case "MulledWine":
                return MULLED_WINE;
            case "Hibernation":
                return HIBERNATION;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COCKTAIL_TYPE,
                        cocktailAsString));

        }

    }

}
