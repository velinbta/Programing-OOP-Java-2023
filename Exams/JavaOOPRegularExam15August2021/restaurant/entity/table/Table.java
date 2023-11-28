package restaurant.entity.table;

import restaurant.entity.food.HealthyFood;
import restaurant.entity.drink.Beverages;

public interface Table {

    int getTableNumber();

    int getSize();

    int numberOfPeople();

    double pricePerPerson();

    boolean isReservedTable();

    double allPeople();

    void reserve(int numberOfPeople);

    void orderHealthy(HealthyFood food);

    void orderBeverages(Beverages beverages);

    double bill();

    void clear();

    String tableInformation();

}
