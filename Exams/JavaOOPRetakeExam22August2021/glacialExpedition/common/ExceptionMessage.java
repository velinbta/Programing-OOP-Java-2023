package glacialExpedition.common;

public class ExceptionMessage {

    private ExceptionMessage() {

    }

    public static final String EXPLORER_NAME_NULL_OR_EMPTY = "Explorer name cannot be null or empty.";

    public static final String EXPLORER_ENERGY_LESS_THAN_ZERO = "Cannot create Explorer with negative energy.";

    public static final String EXPLORER_INVALID_TYPE = "Explorer type doesn't exists.";

    public static final String EXPLORER_DOES_NOT_EXIST_FORMAT = "Explorer %s doesn't exists.";

    public static final String STATE_EXPLORERS_DOES_NOT_EXIST = "You must have at least one explorer to explore the state.";

    public static final String STATE_NAME_NULL_OR_EMPTY = "Invalid name!";

    public static final String INVALID_COMMAND_FORMAT = "Invalid command!: %s";

}
