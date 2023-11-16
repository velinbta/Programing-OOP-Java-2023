package christmasPastryShop.common.enums;

import christmasPastryShop.common.ExceptionMessages;

public enum DelicacyType {

    GINGERBREAD,
    STOLEN;

    public static DelicacyType parseDelicacy(String delicacyAsString) {

        switch (delicacyAsString) {

            case "Gingerbread":
                return GINGERBREAD;
            case "Stolen":
                return STOLEN;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_DELICACY_TYPE,
                        delicacyAsString));
        }

    }

}
