package handball.entities.team;

public class Germany extends BaseTeam {

    private static final int DEFAULT_GERMANY_PLAY_ADVANTAGE = 145;

    public Germany(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        this.setAdvantage(this.getAdvantage() + DEFAULT_GERMANY_PLAY_ADVANTAGE);
    }

}
