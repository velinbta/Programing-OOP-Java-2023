package football.common;

public enum Command {

    ADD_FIELD,
    DELIVERY_SUPPLEMENT,
    SUPPLEMENT_FOR_FIELD,
    ADD_PLAYER,
    DRAG_PLAYER,
    CALCULATE_STRENGTH,
    GET_STATISTICS,
    EXIT;

    public static Command parse(String commandAsString) {

        switch (commandAsString) {

            case "AddField":
                return ADD_FIELD;
            case "DeliverySupplement":
                return DELIVERY_SUPPLEMENT;
            case "SupplementForField":
                return SUPPLEMENT_FOR_FIELD;
            case "AddPlayer":
                return ADD_PLAYER;
            case "DragPlayer":
                return DRAG_PLAYER;
            case "CalculateStrength":
                return CALCULATE_STRENGTH;
            case "GetStatistics":
                return GET_STATISTICS;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND_NAME, commandAsString));
        }

    }

}

