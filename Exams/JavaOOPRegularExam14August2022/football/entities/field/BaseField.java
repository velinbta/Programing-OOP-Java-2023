package football.entities.field;

import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() >= this.capacity) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(this.players); // TODO not mentioned ??
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(this.supplements); // TODO not mentioned ??
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInfo() {

        StringBuilder info = new StringBuilder();

        info.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()));
        info.append(System.lineSeparator());

        String playerInfo = this.players.isEmpty()
                ? "Player: none"
                : String.format("Player: %s",
                this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));

        info.append(playerInfo);
        info.append(System.lineSeparator());

        info.append(String.format("Supplement: %d", this.supplements.size()));
        info.append(System.lineSeparator());

        info.append(String.format("Energy: %d", this.sumEnergy()));

        return info.toString().trim();
    }

}
