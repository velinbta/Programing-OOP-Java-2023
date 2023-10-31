package handball.entities.team;

public class Bulgaria extends BaseTeam {

    private static final int DEFAULT_BULGARIA_PLAY_ADVANTAGE = 115;

    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        this.setAdvantage(this.getAdvantage() + DEFAULT_BULGARIA_PLAY_ADVANTAGE);
    }

}
