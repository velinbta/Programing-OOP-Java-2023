package viceCity.models.players;

import viceCity.common.ExceptionMessage;
import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.Repository;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BasePlayer implements Player {

    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    @Override
    public boolean isAlive() {
        return this.getLifePoints() > 0;
    }

    @Override
    public void takeLifePoints(int points) {
        int decreasedLifePoints = this.getLifePoints() - points;
        this.setLifePoints(Math.max(decreasedLifePoints, 0));
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

}
