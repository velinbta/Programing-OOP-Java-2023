package spaceStation.core;

import spaceStation.common.ConstantMessage;
import spaceStation.common.ExceptionMessage;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private Mission mission;
    private int exploredPlanetsCount;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        Astronaut newAstronaut = this.getAstronautByType(type, astronautName);

        this.astronautRepository.add(newAstronaut);

        return String.format(ConstantMessage.ASTRONAUT_ADDED_FORMAT, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        Planet newPlanet = new PlanetImpl(planetName);
        Arrays.stream(items).forEach(item -> newPlanet.getItems().add(item));

        this.planetRepository.add(newPlanet);

        return String.format(ConstantMessage.PLANET_ADDED_FORMAT, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {

        Astronaut astronautByName = this.astronautRepository.findByName(astronautName);

        if (Objects.isNull(astronautByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.ASTRONAUT_DOES_NOT_EXIST_FORMAT,
                    astronautName));
        }

        this.astronautRepository.remove(astronautByName);

        return String.format(ConstantMessage.ASTRONAUT_RETIRED_FORMAT, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        Collection<Astronaut> suitableAstronauts = this.astronautRepository.getModels().stream().
                filter(astronaut -> astronaut.getOxygen() > 60D).collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.PLANET_ASTRONAUTS_DOES_NOT_EXIST);
        }

        Planet planetToExplore = this.planetRepository.findByName(planetName); // <- always valid

        this.mission.explore(planetToExplore, suitableAstronauts);
        this.exploredPlanetsCount++;

        int deadAstronauts = (int) suitableAstronauts.stream().
                filter(astronaut -> !astronaut.canBreath()).count();

        return String.format(ConstantMessage.PLANET_EXPLORED_FORMAT, planetName, deadAstronauts);
    }

    @Override
    public String report() {

        StringBuilder report = new StringBuilder();

        report.append(String.format(ConstantMessage.REPORT_PLANET_EXPLORED_FORMAT, this.exploredPlanetsCount)).
                append(System.lineSeparator());
        report.append(ConstantMessage.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());

        this.astronautRepository.getModels().forEach(astronaut -> {
            report.append(astronaut);
            report.append(System.lineSeparator());
        });

        return report.toString().trim();
    }

    private Astronaut getAstronautByType(String type, String astronautName) {

        switch (type) {

            case "Biologist":
                return new Biologist(astronautName);
            case "Geodesist":
                return new Geodesist(astronautName);
            case "Meteorologist":
                return new Meteorologist(astronautName);
            default:
                throw new IllegalArgumentException(ExceptionMessage.ASTRONAUT_INVALID_TYPE);
        }

    }

}
