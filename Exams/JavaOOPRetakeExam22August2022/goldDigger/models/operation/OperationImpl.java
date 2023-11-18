package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.Iterator;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        if (spot.getExhibits().isEmpty() || discoverers.isEmpty()) {
            return;
        }

        Iterator<String> exhibitsIterator = spot.getExhibits().iterator();

        for (Discoverer readyDiscoverer : discoverers) {

            while (readyDiscoverer.canDig() && exhibitsIterator.hasNext()) {

                String currentExhibit = exhibitsIterator.next();

                readyDiscoverer.dig();
                readyDiscoverer.getMuseum().getExhibits().add(currentExhibit);
                exhibitsIterator.remove(); // Works only after .next called

            }

        }

    }

}
