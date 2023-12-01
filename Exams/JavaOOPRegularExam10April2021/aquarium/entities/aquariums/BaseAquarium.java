package aquarium.entities.aquariums;

import aquarium.common.ExceptionMessage;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() >= this.capacity) {
            throw new IllegalStateException(ExceptionMessage.NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.AQUARIUM_NAME_NULL_OR_EMPTY);
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
    public Collection<Fish> getFish() {
        return Collections.unmodifiableCollection(this.fish); // TODO not mentioned ??
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return Collections.unmodifiableCollection(this.decorations); // TODO not mentioned ??
    }

    @Override
    public String getInfo() {

        StringBuilder info = new StringBuilder();

        info.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName())).
                append(System.lineSeparator());

        String fishInfo = this.fish.isEmpty()
                ? "Fish: none"
                : String.format("Fish: %s", this.fish.stream().map(Fish::getName).
                collect(Collectors.joining(" ")));

        info.append(fishInfo).append(System.lineSeparator());
        info.append(String.format("Decorations: %d", this.decorations.size())).append(System.lineSeparator());
        info.append(String.format("Comfort: %d", this.calculateComfort()));

        return info.toString().trim();
    }

}
