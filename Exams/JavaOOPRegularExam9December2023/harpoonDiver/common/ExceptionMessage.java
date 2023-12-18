package harpoonDiver.common;

public class ExceptionMessage {

    private ExceptionMessage() {

    }

    public static final String DIVER_NAME_NULL_OR_EMPTY = "Diver name cannot be null or empty.";

    public static final String DIVER_OXYGEN_LESS_THAN_ZERO = "Cannot create Diver with negative oxygen.";

    public static final String DIVER_INVALID_KIND = "Diver kind doesn't exist.";

    public static final String DIVER_DOES_NOT_EXIST_FORMAT = "Diver %s doesn't exist.";

    public static final String SITE_DIVERS_DOES_NOT_EXISTS = "You must have at least one diver to start diving.";

    public static final String SITE_NAME_NULL_OR_EMPTY = "Invalid name!";

    public static final String INVALID_COMMAND_FORMAT = "Invalid command!: %s";

}
