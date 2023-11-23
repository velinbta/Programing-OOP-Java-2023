package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Iterator;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        Iterable<String> exhibitsToExplore = state.getExhibits();
        Iterator<String> exhibitsIterator = exhibitsToExplore.iterator();

        if (!exhibitsIterator.hasNext()) {
            return;
        }

        for (Explorer explorer : explorers) {

            while (exhibitsIterator.hasNext() && explorer.canSearch()) {

                String exhibit = exhibitsIterator.next();
                explorer.search();

                explorer.getSuitcase().getExhibits().add(exhibit);
                exhibitsIterator.remove();
            }

            if (!exhibitsIterator.hasNext()) {
                break;
            }

        }

    }

}
