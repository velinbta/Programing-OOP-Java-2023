package vehicleShop.common;

public enum Command {

    ADD_WORKER,
    ADD_VEHICLE,
    ADD_TOOL_TO_WORKER,
    MAKING_VEHICLE,
    STATISTICS,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {
            case "AddWorker":
                return ADD_WORKER;
            case "AddVehicle":
                return ADD_VEHICLE;
            case "AddToolToWorker":
                return ADD_TOOL_TO_WORKER;
            case "MakingVehicle":
                return MAKING_VEHICLE;
            case "Statistics":
                return STATISTICS;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.COMMAND_DOESNT_EXIST,
                        commandAsString));
        }

    }

}
