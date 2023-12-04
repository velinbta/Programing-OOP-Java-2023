package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        List<Gun> mainPlayerGuns = new ArrayList<>(mainPlayer.getGunRepository().getModels());
        List<Player> civilPlayersList = new ArrayList<>(civilPlayers);

        for (Player civilPlayer : civilPlayersList) {

            if (mainPlayerGuns.isEmpty()) {
                break;
            }

            this.shootUntilPlayerIsAliveOrOthersHaveAGun(civilPlayer, mainPlayerGuns);

        }

        civilPlayersList.removeIf(player -> !player.isAlive());

        for (Player civilPlayer : civilPlayersList) {

            List<Gun> civilPlayerGuns = new ArrayList<>(civilPlayer.getGunRepository().getModels());

            if (civilPlayerGuns.isEmpty()) {
                continue;
            }

            this.shootUntilPlayerIsAliveOrOthersHaveAGun(mainPlayer, civilPlayerGuns);

        }

    }

    private void shootUntilPlayerIsAliveOrOthersHaveAGun(Player targetPlayer, List<Gun> guns) {

        while (targetPlayer.isAlive() && !guns.isEmpty()) {

            Gun currentGun = guns.get(0);
            targetPlayer.takeLifePoints(currentGun.fire());

            if (!currentGun.canFire()) {
                guns.remove(currentGun);
            }

        }

    }

}
