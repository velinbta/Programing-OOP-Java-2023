package restaurant.repository;

public interface TableRepository<T> extends Repository<T> {

    T byNumber(int number);

}
