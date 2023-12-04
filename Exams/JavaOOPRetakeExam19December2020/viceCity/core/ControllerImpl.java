package viceCity.core;

import viceCity.common.ConstantMessage;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Player mainPlayer;
    private Map<String, Player> civilPlayersByName;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayersByName = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {

        Player civilPlayer = new CivilPlayer(name);
        this.civilPlayersByName.put(name, civilPlayer);

        return String.format(ConstantMessage.PLAYER_ADDED_FORMAT, name);
    }

    @Override
    public String addGun(String type, String name) {

        Gun newGun = this.getGunByTypeOrNull(type, name);

        if (Objects.isNull(newGun)) {
            return ConstantMessage.GUN_TYPE_INVALID;
        }

        this.guns.offer(newGun);

        return String.format(ConstantMessage.GUN_ADDED_FORMAT, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        if (this.guns.isEmpty()) {
            return ConstantMessage.GUN_QUEUE_IS_EMPTY;
        }

        Gun firstGun = this.guns.peek();

        if (name.equals("Vercetti")) {
            this.mainPlayer.getGunRepository().add(firstGun);
            this.guns.poll();
            return String.format(ConstantMessage.GUN_ADDED_TO_MAIN_PLAYER_FORMAT, firstGun.getName());
        }

        Player civilPlayer = this.civilPlayersByName.get(name);

        if (Objects.isNull(civilPlayer)) {
            return ConstantMessage.CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        civilPlayer.getGunRepository().add(firstGun);
        this.guns.poll();

        return String.format(ConstantMessage.GUN_ADDED_TO_CIVIL_PLAYER_FORMAT, firstGun.getName(), name);
    }

    @Override
    public String fight() {

        Integer[] initialHealthPointsCivilPlayers = this.getCivilPlayerPointsToArray();

        this.neighbourhood.action(this.mainPlayer, this.civilPlayersByName.values());

        Integer[] afterActionHealthPointsCivilPlayers = this.getCivilPlayerPointsToArray();

        if (this.mainPlayer.getLifePoints() == 100 && // compare all civil players' health points
                Arrays.deepEquals(initialHealthPointsCivilPlayers, afterActionHealthPointsCivilPlayers)) {
            return ConstantMessage.FIGHT_HOT_HAPPENED;
        }

        int deadCivilPlayers = (int) this.civilPlayersByName.values().
                stream().filter(player -> !player.isAlive()).count();

        this.civilPlayersByName.values().removeIf(player -> !player.isAlive());

        int leftCivilPlayers = this.civilPlayersByName.size();

        return this.getFightResult(deadCivilPlayers, leftCivilPlayers);
    }

    @SuppressWarnings("all")
    private String getFightResult(int deadCivilPlayers, int leftCivilPlayers) {

        StringBuilder fightResult = new StringBuilder();

        fightResult.append(ConstantMessage.FIGHT_HAPPENED).append(System.lineSeparator());

        fightResult.append(String.format(ConstantMessage.MAIN_PLAYER_LIVE_POINTS_MESSAGE_FORMAT,
                this.mainPlayer.getLifePoints())).append(System.lineSeparator());

        fightResult.append(String.format(ConstantMessage.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE_FORMAT,
                deadCivilPlayers)).append(System.lineSeparator());

        fightResult.append(String.format(ConstantMessage.CIVIL_PLAYERS_LEFT_MESSAGE_FORMAT, leftCivilPlayers));

        return fightResult.toString().trim();
    }

    private Gun getGunByTypeOrNull(String type, String name) {

        switch (type) {

            case "Pistol":
                return new Pistol(name);
            case "Rifle":
                return new Rifle(name);
            default:
                return null;
        }

    }

    private Integer[] getCivilPlayerPointsToArray() {
        return this.civilPlayersByName.values().stream().
                map(Player::getLifePoints).toArray(Integer[]::new);
    }

}
