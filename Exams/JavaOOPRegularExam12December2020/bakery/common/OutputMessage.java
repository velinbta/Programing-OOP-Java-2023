package bakery.common;

public class OutputMessage {

    private OutputMessage() {

    }

    public static final String FOOD_ADDED_FORMAT = "Added %s (%s) to the menu";

    public static final String DRINK_ADDED_FORMAT = "Added %s (%s) to the drink menu";

    public static final String TABLE_ADDED_FORMAT = "Added table number %d in the bakery";

    public static final String TABLE_RESERVED_FORMAT = "Table %d has been reserved for %d people";

    public static final String RESERVATION_NOT_POSSIBLE_FORMAT = "No available table for %d people";

    public static final String WRONG_TABLE_NUMBER_FORMAT = "Could not find table %d";

    public static final String NONE_EXISTENT_FOOD_FORMAT = "No %s in the menu";

    public static final String FOOD_ORDER_SUCCESSFUL_FORMAT = "Table %d ordered %s";

    public static final String DRINK_ORDER_SUCCESSFUL_FORMAT = "Table %d ordered %s %s";

    public static final String NON_EXISTENT_DRINK_FORMAT = "There is no %s %s available";

    public static final String BILL_FORMAT = "Table: %d%nBill: %.2f";

    public static final String TOTAL_INCOME_FORMAT = "Total income: %.2flv";

}
