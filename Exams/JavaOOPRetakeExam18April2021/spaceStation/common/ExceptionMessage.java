package spaceStation.common;

public class ExceptionMessage {

    private ExceptionMessage() {

    }

    public static final String ASTRONAUT_NAME_NULL_OR_EMPTY = "Astronaut name cannot be null or empty.";

    public static final String ASTRONAUT_OXYGEN_LESS_THAN_ZERO = "Cannot create Astronaut with negative oxygen!";

    public static final String ASTRONAUT_INVALID_TYPE = "Astronaut type doesn't exists!";

    public static final String ASTRONAUT_DOES_NOT_EXIST_FORMAT = "Astronaut %s doesn't exists!";

    public static final String PLANET_ASTRONAUTS_DOES_NOT_EXIST = "You need at least one astronaut to explore the planet!";

    public static final String PLANET_NAME_NULL_OR_EMPTY = "Invalid name!";

    public static final String INVALID_COMMAND_FORMAT = "Invalid command!: %s";

}
