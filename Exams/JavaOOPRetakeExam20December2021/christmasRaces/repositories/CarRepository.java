package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public class CarRepository implements Repository<Car> {

    private Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Car getByName(String carModel) {
        return this.cars.stream().filter(car -> car.getModel().equals(carModel))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.cars);
    }

    @Override
    public void add(Car car) {
        this.cars.add(car);
    }

    @Override
    public boolean remove(Car car) {
        return this.cars.remove(car);
    }

}
