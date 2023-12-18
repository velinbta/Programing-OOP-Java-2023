package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;
import java.util.Iterator;

public class DivingImpl implements Diving {

    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {

        Iterator<String> seaCreaturesIterator = divingSite.getSeaCreatures().iterator();

        if (!seaCreaturesIterator.hasNext()) {
            return;
        }

        for (Diver diver : divers) {

            while (seaCreaturesIterator.hasNext() && diver.canDive()) {

                String nextCreature = seaCreaturesIterator.next();
                diver.shoot();

                diver.getSeaCatch().getSeaCreatures().add(nextCreature);
                seaCreaturesIterator.remove();

            }

            if (!seaCreaturesIterator.hasNext()) {
                break;
            }

        }

    }

}
