package goldDigger.common;

public enum Command {

    ADD_DISCOVERER,
    ADD_SPOT,
    EXCLUDE_DISCOVERER,
    INSPECT_SPOT,
    GET_STATISTICS,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddDiscoverer":
                return ADD_DISCOVERER;
            case "AddSpot":
                return ADD_SPOT;
            case "ExcludeDiscoverer":
                return EXCLUDE_DISCOVERER;
            case "InspectSpot":
                return INSPECT_SPOT;
            case "GetStatistics":
                return GET_STATISTICS;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.COMMAND_DOES_NOT_EXIST,
                        commandAsString));
        }

    }

}
