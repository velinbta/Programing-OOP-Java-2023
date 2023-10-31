package handball.entities.team;

import handball.common.ExceptionMessages;

import java.util.Objects;

public abstract class BaseTeam implements Team {

    private String name;
    private String country;
    private int advantage;

    protected BaseTeam(String name, String country, int advantage) {
        this.setName(name);
        this.setCountry(country);
        this.setAdvantage(advantage);
    }

    @Override
    public void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.TEAM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCountry(String country) {
        if (Objects.isNull(country) || country.isBlank()) {
            throw new NullPointerException(ExceptionMessages.TEAM_COUNTRY_NULL_OR_EMPTY);
        }
        this.country = country;
    }

    protected void setAdvantage(int advantage) {
        if (advantage <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
        }
        this.advantage = advantage;
    }

    @Override
    public abstract void play();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAdvantage() {
        return this.advantage;
    }

}
