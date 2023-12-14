package onlineShop.common;

public class OutputMessage {

    private OutputMessage() {

    }

    public static final String ADDED_COMPUTER_FORMAT = "Computer with id %d added successfully.";

    public static final String ADDED_PERIPHERAL_FORMAT = "Peripheral %s with id %d added successfully in computer with id %d.";

    public static final String REMOVED_PERIPHERAL_FORMAT = "Successfully removed %s with id %d.";

    public static final String ADDED_COMPONENT_FORMAT = "Component %s with id %d added successfully in computer with id %d.";

    public static final String REMOVED_COMPONENT_FORMAT = "Successfully removed %s with id %d.";

    public static final String PRODUCT_TO_STRING_FORMAT = "Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)";

    public static final String COMPONENT_TO_STRING_FORMAT = " Generation: %d";

    public static final String PERIPHERAL_TO_STRING_FORMAT = " Connection Type: %s";

    public static final String COMPUTER_COMPONENTS_TO_STRING_FORMAT = " Components (%d):";

    public static final String COMPUTER_PERIPHERALS_TO_STRING_FORMAT = " Peripherals (%d); Average Overall Performance (%.2f):";

}
