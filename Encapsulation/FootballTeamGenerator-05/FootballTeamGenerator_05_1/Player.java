package FootballTeamGenerator_05_1;

import java.util.Objects;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public double overallSkillLevel() {
        // Average skills for this player
        return Math.round((this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5D);
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank())
            throw stateException("A name should not be empty.");
        this.name = name;
    }

    private void setEndurance(int endurance) {
        ensureStatsRange(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        ensureStatsRange(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        ensureStatsRange(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        ensureStatsRange(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        ensureStatsRange(shooting, "Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return this.name;
    }

    private void ensureStatsRange(int number, String name) {
        if (number < 0 || number > 100) // <- range
            throw stateException(String.format("%s should be between 0 and 100.", name));
    }

    private IllegalStateException stateException(String message) {
        throw new IllegalStateException(message);
    }

}
