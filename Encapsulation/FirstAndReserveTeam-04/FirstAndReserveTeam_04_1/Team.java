package FirstAndReserveTeam_04_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private final String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public void addPlayer(Person person) {
        getTeamAccordingToPersonAge(person).add(person);
    }

    private List<Person> getTeamAccordingToPersonAge(Person person) {
        return person.getAge() < 40
                ? this.firstTeam
                : this.reserveTeam;
    }

    @Override
    public String toString() {

        String team = String.format("First team have %d players", this.getFirstTeam().size()) +
                System.lineSeparator() +
                String.format("Reserve team have %d players", this.getReserveTeam().size());

        return team.trim();
    }

    // Dead code required by Open Judge System:
    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

}
