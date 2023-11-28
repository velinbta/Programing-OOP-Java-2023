package restaurant.repository;

public interface BeverageRepository<T> extends Repository<T> {

    T beverageByName(String drinkName, String drinkBrand);

}
