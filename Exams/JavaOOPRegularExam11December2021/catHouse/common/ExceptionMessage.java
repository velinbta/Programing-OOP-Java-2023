package catHouse.common;

public class ExceptionMessage {

    private ExceptionMessage() {

    }

    public static final String NOT_ENOUGH_CAPACITY_FOR_CAT = "Not enough capacity for this cat.";

    public static final String CAT_NAME_NULL_OR_EMPTY = "Cat name cannot be null or empty.";

    public static final String CAT_BREED_CANNOT_BE_NULL_OR_EMPTY = "Cat breed cannot be null or empty.";

    public static final String CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO = "Cat price cannot be below or equal to 0.";

    public static final String HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY = "House name cannot be null or empty.";

    public static final String INVALID_HOUSE_TYPE = "Invalid house type.";

    public static final String INVALID_TOY_TYPE = "Invalid toy type.";

    public static final String INVALID_CAT_TYPE = "Invalid cat type.";

    public static final String NO_TOY_FOUND_FORMAT = "Toy of type %s is missing.";

    public static final String INVALID_COMMAND_FORMAT = "Invalid command!: %s";

}

