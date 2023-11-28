package restaurant.repository;

import restaurant.entity.drink.Beverages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private Collection<Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }

    @Override
    public void add(Beverages entity) {
        this.beverages.add(entity);
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.beverages.stream().filter(beverage -> beverage.getName().equals(drinkName)).
                filter(beverage -> beverage.getBrand().equals(drinkBrand)).
                findFirst().orElse(null); // TODO brand ??
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.beverages);
    }

}
