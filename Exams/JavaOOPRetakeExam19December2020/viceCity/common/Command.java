package viceCity.common;

public enum Command {

    ADD_PLAYER,
    ADD_GUN,
    ADD_GUN_TO_PLAYER,
    FIGHT,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {
            case "AddPlayer":
                return ADD_PLAYER;
            case "AddGun":
                return ADD_GUN;
            case "AddGunToPlayer":
                return ADD_GUN_TO_PLAYER;
            case "Fight":
                return FIGHT;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
