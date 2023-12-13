package bakery.repositories;

import bakery.entities.drinks.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public class DrinkRepositoryImpl implements DrinkRepository<Drink> {

    private Collection<Drink> drinks;

    public DrinkRepositoryImpl() {
        this.drinks = new ArrayList<>();
    }

    @Override
    public void add(Drink drink) {
        this.drinks.add(drink);
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(this.drinks);
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return this.drinks.stream().filter(drink -> drink.getName().equals(drinkName) &&
                drink.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

}
