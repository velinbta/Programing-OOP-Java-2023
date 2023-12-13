package bakery.repositories;

public interface TableRepository<T> extends Repository<T> {

    T getByNumber(int number);

}

