package christmasPastryShop.repositories;

import christmasPastryShop.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public abstract class RepositoryImpl<T> implements Repository<T> {

    private Collection<T> models;

    protected RepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(T t) {
        this.models.add(t);
    }

}
