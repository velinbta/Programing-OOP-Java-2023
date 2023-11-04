package bank.common;

public enum Command {

    ADD_BANK,
    ADD_LOAN,
    RETURNED_LOAN,
    ADD_CLIENT,
    FINAL_CALCULATION,
    STATISTICS,
    END;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddBank":
                return ADD_BANK;
            case "AddLoan":
                return ADD_LOAN;
            case "ReturnedLoan":
                return RETURNED_LOAN;
            case "AddClient":
                return ADD_CLIENT;
            case "FinalCalculation":
                return FINAL_CALCULATION;
            case "Statistics":
                return STATISTICS;
            case "End":
                return END;
            default:
                throw new IllegalArgumentException(ExceptionMessages.UNKNOWN_COMMAND);
        }

    }

}
