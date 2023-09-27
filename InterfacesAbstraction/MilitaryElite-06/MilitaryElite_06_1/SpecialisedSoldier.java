package MilitaryElite_06_1;

// Should be inherited
public abstract class SpecialisedSoldier extends Private {

    public enum Corps {

        AIRFORCES,
        MARINES;

        public static Corps parseCorps(String corpsAsString) {

            switch (corpsAsString) {

                case "Airforces":
                    return AIRFORCES;
                case "Marines":
                    return MARINES;
                default:
                    throw argumentException(corpsAsString);
            }

        }

        public static String parseCorps(Corps corps) {

            switch (corps) {

                case AIRFORCES:
                    return "Airforces";
                case MARINES:
                    return "Marines";
                default:
                    throw argumentException(corps.name());
            }

        }

        public static boolean containsCorps(String corpsAsString) {
            return corpsAsString.equalsIgnoreCase(AIRFORCES.name()) ||
                    corpsAsString.equalsIgnoreCase(MARINES.name());
        }

        private static IllegalArgumentException argumentException(String argument) {
            throw new IllegalArgumentException("Invalid value " + argument);
        }

    }

    public static final int DEFAULT_SIZE = 6;

    private final Corps corps;

    protected SpecialisedSoldier(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    public Corps getCorps() {
        return this.corps;
    }

    @Override
    @SuppressWarnings({"all"})
    public String toString() {

        StringBuilder specialised = new StringBuilder();
        specialised.append(super.toString());
        specialised.append(System.lineSeparator());

        specialised.append(String.format("Corps: %s", Corps.parseCorps(this.getCorps())));

        return specialised.toString().trim();

    }

}
