package restaurant.repository;

public interface HealthFoodRepository<T> extends Repository<T> {

    T foodByName(String name);

}
