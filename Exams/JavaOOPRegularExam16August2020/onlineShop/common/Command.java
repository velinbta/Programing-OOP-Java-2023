package onlineShop.common;

public enum Command {

    ADD_COMPUTER,
    ADD_PERIPHERAL,
    REMOVE_PERIPHERAL,
    ADD_COMPONENT,
    REMOVE_COMPONENT,
    BUY_COMPUTER,
    BUY_BEST_COMPUTER,
    GET_COMPUTER_DATA,
    CLOSE;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddComputer":
                return ADD_COMPUTER;
            case "AddPeripheral":
                return ADD_PERIPHERAL;
            case "RemovePeripheral":
                return REMOVE_PERIPHERAL;
            case "AddComponent":
                return ADD_COMPONENT;
            case "RemoveComponent":
                return REMOVE_COMPONENT;
            case "BuyComputer":
                return BUY_COMPUTER;
            case "BuyBestComputer":
                return BUY_BEST_COMPUTER;
            case "GetComputerData":
                return GET_COMPUTER_DATA;
            case "Close":
                return CLOSE;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
