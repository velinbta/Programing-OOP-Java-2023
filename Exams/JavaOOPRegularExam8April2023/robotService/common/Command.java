package robotService.common;

public enum Command {

    ADD_SERVICE,
    ADD_SUPPLEMENT,
    SUPPLEMENT_FOR_SERVICE,
    ADD_ROBOT,
    FEEDING_ROBOT,
    SUM_OF_ALL,
    STATISTICS,
    END;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {
            case "AddService":
                return ADD_SERVICE;
            case "AddSupplement":
                return ADD_SUPPLEMENT;
            case "SupplementForService":
                return SUPPLEMENT_FOR_SERVICE;
            case "AddRobot":
                return ADD_ROBOT;
            case "FeedingRobot":
                return FEEDING_ROBOT;
            case "SumOfAll":
                return SUM_OF_ALL;
            case "Statistics":
                return STATISTICS;
            case "End":
                return END;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.UNKNOWN_COMMAND, commandAsString));
        }

    }

}
