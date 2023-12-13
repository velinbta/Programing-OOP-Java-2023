package easterRaces.repositories;

import easterRaces.entities.cars.Car;

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
    public void add(Car model) {
        this.cars.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return this.cars.remove(model);
    }

    @Override
    public Car getByName(String name) {
        return this.cars.stream().filter(car -> car.getModel().equals(name)).
                findFirst().orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.cars);
    }

}
