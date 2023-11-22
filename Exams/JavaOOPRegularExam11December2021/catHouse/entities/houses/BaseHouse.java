package catHouse.entities.houses;

import catHouse.common.ExceptionMessage;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() >= this.capacity) {
            throw new IllegalStateException(ExceptionMessage.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format("%s %s:", this.getName(), this.getClass().getSimpleName()));
        statistics.append(System.lineSeparator());

        String catInfo = this.cats.isEmpty()
                ? "Cats: none"
                : String.format("Cats: %s", this.cats.stream().map(Cat::getName).
                collect(Collectors.joining(" ")));

        statistics.append(catInfo);
        statistics.append(System.lineSeparator());

        statistics.append(String.format("Toys: %d Softness: %d", this.toys.size(), this.sumSoftness()));

        return statistics.toString().trim();
    }

    @Override
    public void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
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
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(this.cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(this.toys);
    }

}
