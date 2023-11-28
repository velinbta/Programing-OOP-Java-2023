package restaurant.common;

public class OutputMessage {

    private OutputMessage() {

    }

    public static final String FOOD_ADDED_FORMAT = "Added %s to the healthy menu!";

    public static final String BEVERAGE_ADDED_FORMAT = "Added %s - %s to the beverage menu!";

    public static final String TABLE_ADDED_FORMAT = "Added table number %d in the healthy restaurant!";

    public static final String TABLE_RESERVED_FORMAT = "Table %d has been reserved for %d people.";

    public static final String RESERVATION_NOT_POSSIBLE_FORMAT = "There is no such table for %d people.";

    public static final String WRONG_TABLE_NUMBER_FORMAT = "Could not find table %d.";

    public static final String NONE_EXISTENT_FOOD_FORMAT = "No %s in the healthy menu.";

    public static final String FOOD_ORDER_SUCCESSFUL_FORMAT = "%s ordered from table %d.";

    public static final String BEVERAGE_ORDER_SUCCESSFUL_FORMAT = "%s ordered from table %d.";

    public static final String NON_EXISTENT_DRINK_FORMAT = "No %s - %s in the beverage menu.";

    public static final String BILL_FORMAT = "Table: %d with bill: %.2f";

    public static final String TOTAL_MONEY_FORMAT =  "Total money for the restaurant: %.2flv.";

}
