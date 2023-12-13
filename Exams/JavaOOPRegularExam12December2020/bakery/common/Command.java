package bakery.common;

public enum Command {

    ADD_FOOD,
    ADD_DRINK,
    ADD_TABLE,
    RESERVE_TABLE,
    ORDER_FOOD,
    ORDER_DRINK,
    LEAVE_TABLE,
    GET_FREE_TABLES_INFO,
    GET_TOTAL_INCOME,
    END;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddFood":
                return ADD_FOOD;
            case "AddDrink":
                return ADD_DRINK;
            case "AddTable":
                return ADD_TABLE;
            case "ReserveTable":
                return RESERVE_TABLE;
            case "OrderFood":
                return ORDER_FOOD;
            case "OrderDrink":
                return ORDER_DRINK;
            case "LeaveTable":
                return LEAVE_TABLE;
            case "GetFreeTablesInfo":
                return GET_FREE_TABLES_INFO;
            case "GetTotalIncome":
                return GET_TOTAL_INCOME;
            case "END":
                return END;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
