package bakery.repositories;

public interface FoodRepository<T> extends Repository<T> {

    T getByName(String name);

}
