package handball.common;

public enum Command {

    ADD_GAMEPLAY,
    ADD_TEAM,
    ADD_EQUIPMENT,
    EQUIPMENT_REQUIREMENT,
    PLAY_IN_GAMEPLAY,
    PERCENT_ADVANTAGE,
    GET_STATISTICS,
    EXIT;

    public static Command parseCommand(String commandAsString) {

        switch (commandAsString) {

            case "AddGameplay":
                return ADD_GAMEPLAY;
            case "AddTeam":
                return ADD_TEAM;
            case "AddEquipment":
                return ADD_EQUIPMENT;
            case "EquipmentRequirement":
                return EQUIPMENT_REQUIREMENT;
            case "PlayInGameplay":
                return PLAY_IN_GAMEPLAY;
            case "PercentAdvantage":
                return PERCENT_ADVANTAGE;
            case "GetStatistics":
                return GET_STATISTICS;
            case "Exit":
                return EXIT;
            default:
                throw new IllegalArgumentException("Unknown command: " + commandAsString);
        }

    }

}