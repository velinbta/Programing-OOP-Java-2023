package christmasRaces.common;

public enum Command {

    CREATE_DRIVER,
    CREATE_CAR,
    ADD_CAR_TO_DRIVER,
    ADD_DRIVER_TO_RACE,
    CREATE_RACE,
    START_RACE,
    END;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "CreateDriver":
                return CREATE_DRIVER;
            case "CreateCar":
                return CREATE_CAR;
            case "AddCarToDriver":
                return ADD_CAR_TO_DRIVER;
            case "AddDriverToRace":
                return ADD_DRIVER_TO_RACE;
            case "CreateRace":
                return CREATE_RACE;
            case "StartRace":
                return START_RACE;
            case "End":
                return END;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
