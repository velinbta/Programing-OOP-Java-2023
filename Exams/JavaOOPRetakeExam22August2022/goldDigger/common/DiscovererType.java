package goldDigger.common;

public enum DiscovererType {

    ARCHAEOLOGIST,
    ANTHROPOLOGIST,
    GEOLOGIST;

    public static DiscovererType parse(String discovererAsString) {

        switch (discovererAsString) {
            case "Archaeologist":
                return ARCHAEOLOGIST;
            case "Anthropologist":
                return ANTHROPOLOGIST;
            case "Geologist":
                return GEOLOGIST;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);

        }

    }

}
