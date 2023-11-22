package catHouse.common;

public enum Command {

    ADD_HOUSE,
    BUY_TOY,
    TOY_FOR_HOUSE,
    ADD_CAT,
    FEEDING_CAT,
    SUM_OF_ALL,
    STATISTICS,
    END;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddHouse":
                return ADD_HOUSE;
            case "BuyToy":
                return BUY_TOY;
            case "ToyForHouse":
                return TOY_FOR_HOUSE;
            case "AddCat":
                return ADD_CAT;
            case "FeedingCat":
                return FEEDING_CAT;
            case "SumOfAll":
                return SUM_OF_ALL;
            case "Statistics":
                return STATISTICS;
            case "End":
                return END;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
