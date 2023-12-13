package easterRaces.repositories;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public class RaceRepository implements Repository<Race> {

    private Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public void add(Race model) {
        this.races.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.races.remove(model);
    }

    @Override
    public Race getByName(String name) {
        return this.races.stream().filter(race -> race.getName().equals(name)).
                findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.races);
    }

}
