package restaurant.repository;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAllEntities();

    void add(T entity);

}
