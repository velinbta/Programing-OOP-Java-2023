package spaceStation.common;

public enum Command {

    ADD_ASTRONAUT,
    ADD_PLANET,
    RETIRE_ASTRONAUT,
    EXPLORE_PLANET,
    REPORT,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddAstronaut":
                return ADD_ASTRONAUT;
            case "AddPlanet":
                return ADD_PLANET;
            case "RetireAstronaut":
                return RETIRE_ASTRONAUT;
            case "ExplorePlanet":
                return EXPLORE_PLANET;
            case "Report":
                return REPORT;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
