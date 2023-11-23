package glacialExpedition.common;

public enum Command {

    ADD_EXPLORER,
    ADD_STATE,
    RETIRE_EXPLORER,
    EXPLORE_STATE,
    FINAL_RESULT,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddExplorer":
                return ADD_EXPLORER;
            case "AddState":
                return ADD_STATE;
            case "RetireExplorer":
                return RETIRE_EXPLORER;
            case "ExploreState":
                return EXPLORE_STATE;
            case "FinalResult":
                return FINAL_RESULT;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
