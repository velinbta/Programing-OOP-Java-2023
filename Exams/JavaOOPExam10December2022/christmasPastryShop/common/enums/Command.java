package christmasPastryShop.common.enums;

import christmasPastryShop.common.ExceptionMessages;

public enum Command {

    ADD_DELICACY,
    ADD_COCKTAIL,
    ADD_BOOTH,
    RESERVE_BOOTH,
    ORDER_DELICACY,
    ORDER_COCKTAIL,
    LEAVE_BOOTH,
    GET_INCOME,
    END;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddDelicacy":
                return ADD_DELICACY;
            case "AddCocktail":
                return ADD_COCKTAIL;
            case "AddBooth":
                return ADD_BOOTH;
            case "ReserveBooth":
                return RESERVE_BOOTH;
            case "OrderDelicacy":
                return ORDER_DELICACY;
            case "OrderCocktail":
                return ORDER_COCKTAIL;
            case "LeaveBooth":
                return LEAVE_BOOTH;
            case "GetIncome":
                return GET_INCOME;
            case "END":
                return END;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND_TYPE,
                        commandAsString));
        }

    }

}
