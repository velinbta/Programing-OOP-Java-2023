package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.DiscovererType;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;
    private Operation operation;
    private int inspectedSpotCount;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.operation = new OperationImpl();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        Discoverer newDiscoverer = this.getDiscovererByKind(kind, discovererName);

        this.discovererRepository.add(newDiscoverer);

        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {

        Spot newSpot = new SpotImpl(spotName);
        Arrays.stream(exhibits).forEach(exhibit -> newSpot.getExhibits().add(exhibit));

        this.spotRepository.add(newSpot);

        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {

        boolean isExcluded = this.discovererRepository.remove(this.discovererRepository.byName(discovererName));

        String message = isExcluded
                ? String.format(ConstantMessages.DISCOVERER_EXCLUDED, discovererName)
                : String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName);

        if (!isExcluded) {
            throw new IllegalArgumentException(message);
        }

        return message;
    }

    @Override
    public String inspectSpot(String spotName) {

        Collection<Discoverer> discoverers = this.discovererRepository.getCollection().stream()
                .filter(discoverer -> discoverer.getEnergy() > 45D).collect(Collectors.toList());

        if (discoverers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXIST);
        }

        Spot spot = this.spotRepository.byName(spotName);
        this.operation.startOperation(spot, discoverers);

        this.inspectedSpotCount++;

        int excludedDiscoverers = (int) discoverers.stream().
                filter(discoverer -> !discoverer.canDig()).count();

        return String.format(ConstantMessages.INSPECT_SPOT, spotName, excludedDiscoverers);
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, this.inspectedSpotCount));
        statistics.append(System.lineSeparator());

        statistics.append(ConstantMessages.FINAL_DISCOVERER_INFO);
        statistics.append(System.lineSeparator());

        this.discovererRepository.getCollection().forEach(discoverer -> {
            statistics.append(discoverer);
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private Discoverer getDiscovererByKind(String kind, String discovererName) {

        switch (DiscovererType.parse(kind)) {

            case ARCHAEOLOGIST:
                return new Archaeologist(discovererName);
            case ANTHROPOLOGIST:
                return new Anthropologist(discovererName);
            case GEOLOGIST:
                return new Geologist(discovererName);
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);

        }

    }

}
