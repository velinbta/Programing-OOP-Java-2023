package MilitaryElite_06_1;

import java.util.ArrayList;
import java.util.Collection;

public class Commando extends BaseSpecialisedSoldier {

    private final Collection<Mission> missions;

    protected Commando(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {

        StringBuilder commando = new StringBuilder();
        commando.append(super.toString());
        commando.append(System.lineSeparator());
        commando.append("Missions:");

        if (missions.isEmpty()) {
            return commando.toString().trim();
        }

        commando.append(System.lineSeparator());

        this.missions.forEach(mission -> {
            commando.append(mission);
            commando.append(System.lineSeparator());
        });

        return commando.toString().trim();
    }

}
