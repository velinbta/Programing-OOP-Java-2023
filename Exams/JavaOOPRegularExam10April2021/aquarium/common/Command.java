package aquarium.common;

public enum Command {

    ADD_AQUARIUM,
    ADD_DECORATION,
    INSERT_DECORATION,
    ADD_FISH,
    FEED_FISH,
    CALCULATE_VALUE,
    REPORT,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddAquarium":
                return ADD_AQUARIUM;
            case "AddDecoration":
                return ADD_DECORATION;
            case "InsertDecoration":
                return INSERT_DECORATION;
            case "AddFish":
                return ADD_FISH;
            case "FeedFish":
                return FEED_FISH;
            case "CalculateValue":
                return CALCULATE_VALUE;
            case "Report":
                return REPORT;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
