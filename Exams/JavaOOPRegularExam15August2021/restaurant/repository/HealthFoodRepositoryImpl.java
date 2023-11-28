package restaurant.repository;

import restaurant.entity.food.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

    private Collection<HealthyFood> foods;

    public HealthFoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(HealthyFood entity) {
        this.foods.add(entity);
    }

    @Override
    public HealthyFood foodByName(String name) {
        return this.foods.stream().filter(food -> food.getName().equals(name)).
                findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(this.foods);
    }

}
