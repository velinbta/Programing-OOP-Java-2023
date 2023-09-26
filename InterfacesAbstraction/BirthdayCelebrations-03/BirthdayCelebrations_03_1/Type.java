package BirthdayCelebrations_03_1;

public enum Type {

    CITIZEN,
    ROBOT,
    PET;

    public static Type parseType(String typeAsString) {

        switch (typeAsString) {

            case "Citizen":
                return CITIZEN;
            case "Robot":
                return ROBOT;
            case "Pet":
                return PET;

        }

        throw typeException(typeAsString);
    }

    public static IllegalArgumentException typeException(String type) {
        throw new IllegalArgumentException("Unknown type " + type);
    }

}
