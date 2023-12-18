package harpoonDiver.repositories;

import harpoonDiver.models.divingSite.DivingSite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public class DivingSiteRepository implements Repository<DivingSite> {

    private Collection<DivingSite> divingSites;

    public DivingSiteRepository() {
        this.divingSites = new ArrayList<>();
    }

    @Override
    public void add(DivingSite entity) {
        this.divingSites.add(entity);
    }

    @Override
    public boolean remove(DivingSite entity) {
        return this.divingSites.remove(entity);
    }

    @Override
    public Collection<DivingSite> getCollection() {
        return Collections.unmodifiableCollection(this.divingSites);
    }

    @Override
    public DivingSite byName(String name) {
        return this.divingSites.stream().filter(divingSite -> divingSite.getName().equals(name)).
                findFirst().orElse(null);
    }

}
