package zoo.common;

public enum Command {

    ADD_AREA,
    BUY_FOOD,
    FOOD_FOR_AREA,
    ADD_ANIMAL,
    FEED_ANIMAL,
    CALCULATE_KG,
    GET_STATISTICS,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddArea":
                return ADD_AREA;
            case "BuyFood":
                return BUY_FOOD;
            case "FoodForArea":
                return FOOD_FOR_AREA;
            case "AddAnimal":
                return ADD_ANIMAL;
            case "FeedAnimal":
                return FEED_ANIMAL;
            case "CalculateKg":
                return CALCULATE_KG;
            case "GetStatistics":
                return GET_STATISTICS;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND,
                        commandAsString));
        }

    }

}

