package restaurant.common;

public enum Command {

    ADD_HEALTHY_FOOD,
    ADD_BEVERAGE,
    ADD_TABLE,
    RESERVE,
    ORDER_HEALTHY_FOOD,
    ORDER_BEVERAGE,
    CLOSED_BILL,
    TOTAL_MONEY,
    END;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "addHealthyFood":
                return ADD_HEALTHY_FOOD;
            case "addBeverage":
                return ADD_BEVERAGE;
            case "addTable":
                return ADD_TABLE;
            case "reserve":
                return RESERVE;
            case "orderHealthyFood":
                return ORDER_HEALTHY_FOOD;
            case "orderBeverage":
                return ORDER_BEVERAGE;
            case "closedBill":
                return CLOSED_BILL;
            case "totalMoney":
                return TOTAL_MONEY;
            case "END":
                return END;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
