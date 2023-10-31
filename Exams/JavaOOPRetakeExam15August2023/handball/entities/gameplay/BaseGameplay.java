package handball.entities.gameplay;

import handball.common.ExceptionMessages;
import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseGameplay implements Gameplay {

    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    protected BaseGameplay(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.GAMEPLAY_CAPACITY_BELOW_OR_EQUAL_ZERO);
        }
        this.capacity = capacity;
    }

    @Override
    public int allProtection() {
        return this.equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        if (this.capacity == 0) {
            return;
        }

        this.capacity--;
        this.teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        if (this.teams.remove(team)) {
            this.capacity++;
        }
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        this.getTeam().forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return Collections.unmodifiableCollection(this.teams);
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return Collections.unmodifiableCollection(this.equipments);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {

        StringBuilder gameplayOutput = new StringBuilder();

        gameplayOutput.append(String.format("%s %s", this.getName(), this.getClass().getSimpleName()));
        gameplayOutput.append(System.lineSeparator());

        String team = this.getTeam().isEmpty()
                ? "Team: none"
                : "Team:";

        gameplayOutput.append(team);
        this.getTeam().forEach(t -> gameplayOutput.append(" ").append(t.getName()));
        gameplayOutput.append(System.lineSeparator());

        int equipmentsCount = this.getEquipments().size();
        int totalProtection = this.allProtection();

        gameplayOutput.append(String.format("Equipment: %d, Protection: %d", equipmentsCount, totalProtection));

        return gameplayOutput.toString().trim();
    }

}
