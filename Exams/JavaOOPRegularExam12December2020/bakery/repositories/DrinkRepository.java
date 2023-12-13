package bakery.repositories;

public interface DrinkRepository<T> extends Repository<T> {

    T getByNameAndBrand(String drinkName,String drinkBrand);

}
