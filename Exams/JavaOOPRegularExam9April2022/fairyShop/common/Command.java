package fairyShop.common;

public enum Command {

    ADD_HELPER,
    ADD_PRESENT,
    ADD_INSTRUMENT_TO_HELPER,
    CRAFT_PRESENT,
    REPORT,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddHelper":
                return ADD_HELPER;
            case "AddPresent":
                return ADD_PRESENT;
            case "AddInstrumentToHelper":
                return ADD_INSTRUMENT_TO_HELPER;
            case "CraftPresent":
                return CRAFT_PRESENT;
            case "Report":
                return REPORT;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND,
                        commandAsString));
        }

    }

}
