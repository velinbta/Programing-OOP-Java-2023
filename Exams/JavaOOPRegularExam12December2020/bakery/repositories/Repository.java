package bakery.repositories;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAll();

    void add(T t);

}
