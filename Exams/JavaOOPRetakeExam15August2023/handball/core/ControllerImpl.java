package handball.core;

import handball.common.ConstantMessages;
import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {

        Gameplay foundGameplay = this.getGameplayByTypeOrNull(gameplayType, gameplayName);

        if (Objects.isNull(foundGameplay)) {
            throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }

        this.gameplays.add(foundGameplay);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {

        Equipment foundEquipment = this.getEquipmentByTypeOrNull(equipmentType);

        if (Objects.isNull(foundEquipment)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }

        this.equipment.add(foundEquipment);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {

        Equipment byType = this.equipment.findByType(equipmentType);

        if (Objects.isNull(byType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));
        }

        Gameplay gameplayByName = this.findGameplayByName(gameplayName);
        gameplayByName.addEquipment(byType);

        this.equipment.remove(byType);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {

        Team foundTeam = this.getTeamByTypeOrNull(teamType, teamName, country, advantage);

        if (Objects.isNull(foundTeam)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }

        Gameplay gameplayByName = this.findGameplayByName(gameplayName);

        boolean isTerrainSuitable = this.checkSuitable(foundTeam, gameplayByName);

        if (!isTerrainSuitable) {
            return ConstantMessages.GAMEPLAY_NOT_SUITABLE;
        }

        gameplayByName.addTeam(foundTeam);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {

        Gameplay gameplayByName = this.findGameplayByName(gameplayName);
        this.findGameplayByName(gameplayName).teamsInGameplay();

        int teamsPlayed = gameplayByName.getTeam().size();

        return String.format(ConstantMessages.TEAMS_PLAYED, teamsPlayed);
    }

    @Override
    public String percentAdvantage(String gameplayName) {

        Gameplay gameplayByName = this.findGameplayByName(gameplayName);

        int teamSumAdvantages = gameplayByName.getTeam().stream().mapToInt(Team::getAdvantage).sum();

        return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY, gameplayName, teamSumAdvantages);
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        this.gameplays.forEach(gameplay -> {
            statistics.append(gameplay.toString());
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private Gameplay findGameplayByName(String gameplayName) {
        return this.gameplays.stream().filter(g -> g.getName().equals(gameplayName)).
                findFirst().get();
    }

    private Gameplay getGameplayByTypeOrNull(String gameplayType, String gameplayName) {

        switch (gameplayType) {
            case "Outdoor":
                return new Outdoor(gameplayName);
            case "Indoor":
                return new Indoor(gameplayName);
            default:
                return null;
        }

    }

    private Equipment getEquipmentByTypeOrNull(String equipmentType) {

        switch (equipmentType) {
            case "Kneepad":
                return new Kneepad();
            case "ElbowPad":
                return new ElbowPad();
            default:
                return null;
        }

    }

    private Team getTeamByTypeOrNull(String teamType, String teamName, String country, int advantage) {

        switch (teamType) {
            case "Bulgaria":
                return new Bulgaria(teamName, country, advantage);
            case "Germany":
                return new Germany(teamName, country, advantage);
            default:
                return null;
        }

    }

    private boolean checkSuitable(Team foundTeam, Gameplay currentGameplay) {

        String teamSimpleName = foundTeam.getClass().getSimpleName();
        String gameplaySimpleName = currentGameplay.getClass().getSimpleName();

        boolean isBulgariaOutdoor = teamSimpleName.equals("Bulgaria") && gameplaySimpleName.equals("Outdoor");
        boolean isGermanyIndoor = teamSimpleName.equals("Germany") && gameplaySimpleName.equals("Indoor");

        return isBulgariaOutdoor || isGermanyIndoor;

    }

}
