package bakery.repositories;

import bakery.entities.bakedFoods.BakedFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public class FoodRepositoryImpl implements FoodRepository<BakedFood> {

    private Collection<BakedFood> food;

    public FoodRepositoryImpl() {
        this.food = new ArrayList<>();
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.food.add(bakedFood);
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(this.food);
    }

    @Override
    public BakedFood getByName(String name) {
        return this.food.stream().filter(bakedFood -> bakedFood.getName().equals(name)).
                findFirst().orElse(null);
    }

}
