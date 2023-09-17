package FootballTeamGenerator_05_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Team {

    private String name;
    private final List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank())
            throw stateException("A name should not be empty.");
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        Optional<Player> player = this.players.stream().filter(p -> p.getName().equals(name))
                .findFirst();

        player.ifPresentOrElse(this.players::remove, // <- or else exception
                () -> stateException(String.format("Player %s is not in %s team.", name, this.getName())));
    }

    public double getRating() {
        // Rounded up all players average
        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).
                average().orElse(0D));
    }

    public String getName() {
        return this.name;
    }

    private IllegalStateException stateException(String message) {
        throw new IllegalStateException(message);
    }

}
