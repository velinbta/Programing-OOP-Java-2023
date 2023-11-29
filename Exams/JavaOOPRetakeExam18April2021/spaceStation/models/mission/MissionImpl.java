package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Iterator;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        Iterator<String> iterator = planet.getItems().iterator();

        if (!iterator.hasNext()) {
            return;
        }

        for (Astronaut astronaut : astronauts) {

            while (iterator.hasNext() && astronaut.canBreath()) {

                String item = iterator.next();

                astronaut.breath();
                astronaut.getBag().getItems().add(item);

                iterator.remove();
            }

            if (!iterator.hasNext()) {
                break;
            }

        }

    }

}
