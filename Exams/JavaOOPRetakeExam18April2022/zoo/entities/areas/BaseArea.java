package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(this.animals); // TODO not mentioned ??
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(this.foods); // TODO not mentioned ??
    }

    @Override
    public int sumCalories() {
        return this.foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.animals.size() >= this.capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        this.animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {

        StringBuilder info = new StringBuilder();

        info.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()));
        info.append(System.lineSeparator());

        String animalsInfo = this.animals.isEmpty()
                ? "Animals: none"
                : String.format("Animals: %s", this.animals.stream().map(Animal::getName).
                collect(Collectors.joining(" ")));

        info.append(animalsInfo);
        info.append(System.lineSeparator());

        info.append(String.format("Foods: %d", this.foods.size()));
        info.append(System.lineSeparator());

        info.append(String.format("Calories: %d", this.sumCalories()));

        return info.toString().trim();
    }

}
