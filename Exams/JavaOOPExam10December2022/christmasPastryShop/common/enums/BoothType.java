package christmasPastryShop.common.enums;

import christmasPastryShop.common.ExceptionMessages;

public enum BoothType {

    OPEN_BOOTH,
    PRIVATE_BOOTH;

    public static BoothType parseBooth(String bootAsString) {

        switch (bootAsString) {

            case "OpenBooth":
                return OPEN_BOOTH;
            case "PrivateBooth":
                return PRIVATE_BOOTH;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_BOOTH_TYPE,
                        bootAsString));
        }

    }

}
