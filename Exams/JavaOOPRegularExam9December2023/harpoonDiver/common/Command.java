package harpoonDiver.common;

public enum Command {

    ADD_DIVER,
    ADD_DIVING_SITE,
    REMOVE_DIVER,
    START_DIVING,
    GET_STATISTICS,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddDiver":
                return ADD_DIVER;
            case "AddDivingSite":
                return ADD_DIVING_SITE;
            case "RemoveDiver":
                return REMOVE_DIVER;
            case "StartDiving":
                return START_DIVING;
            case "GetStatistics":
                return GET_STATISTICS;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
