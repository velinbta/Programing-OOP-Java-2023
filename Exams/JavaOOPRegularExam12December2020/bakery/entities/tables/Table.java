package bakery.entities.tables;

import bakery.entities.bakedFoods.BakedFood;
import bakery.entities.drinks.Drink;

public interface Table {

    int getTableNumber();

    int getCapacity();

    int getNumberOfPeople();

    double getPricePerPerson();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    void orderFood(BakedFood food);

    void orderDrink(Drink drink);

    double getBill();

    void clear();

    String getFreeTableInfo();

}
