package harpoonDiver.core;

import harpoonDiver.common.ConstantMessage;
import harpoonDiver.common.ExceptionMessage;
import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository<Diver> diverRepository;
    private Repository<DivingSite> divingSiteRepository;
    private Diving diving;
    private int divingSitesCount;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
        this.diving = new DivingImpl();
    }

    @Override
    public String addDiver(String kind, String diverName) {

        Diver newDiver = this.getDiverByKind(kind, diverName);
        this.diverRepository.add(newDiver);

        return String.format(ConstantMessage.DIVER_ADDED_FORMAT, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {

        DivingSite newDivingSite = new DivingSiteImpl(siteName);
        Arrays.stream(seaCreatures).forEach(seaCreature ->
                newDivingSite.getSeaCreatures().add(seaCreature));

        this.divingSiteRepository.add(newDivingSite);

        return String.format(ConstantMessage.DIVING_SITE_ADDED_FORMAT, siteName);
    }

    @Override
    public String removeDiver(String diverName) {

        Diver diverByName = this.diverRepository.byName(diverName);

        if (Objects.isNull(diverByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.
                    DIVER_DOES_NOT_EXIST_FORMAT, diverName));
        }

        this.diverRepository.remove(diverByName);

        return String.format(ConstantMessage.DIVER_REMOVE_FORMAT, diverName);
    }

    @Override
    public String startDiving(String siteName) {

        Collection<Diver> suitableDivers = this.diverRepository.getCollection().stream()
                .filter(diver -> diver.getOxygen() > 30).collect(Collectors.toList());

        if (suitableDivers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.SITE_DIVERS_DOES_NOT_EXISTS);
        }

        DivingSite divingSiteByName = this.divingSiteRepository.byName(siteName);

        this.diving.searching(divingSiteByName, suitableDivers);

        int removedDivers = (int) suitableDivers.stream().filter(diver -> !diver.canDive()).count();
        this.divingSitesCount++;

        return String.format(ConstantMessage.SITE_DIVING_FORMAT, siteName, removedDivers);
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format(ConstantMessage.FINAL_DIVING_SITES_FORMAT, this.divingSitesCount)).
                append(System.lineSeparator());

        statistics.append(ConstantMessage.FINAL_DIVERS_STATISTICS).append(System.lineSeparator());

        this.diverRepository.getCollection().forEach(diver -> {
            statistics.append(diver);
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private Diver getDiverByKind(String kind, String diverName) {

        switch (kind) {

            case "DeepWaterDiver":
                return new DeepWaterDiver(diverName);
            case "OpenWaterDiver":
                return new OpenWaterDiver(diverName);
            case "WreckDiver":
                return new WreckDiver(diverName);
            default:
                throw new IllegalArgumentException(ExceptionMessage.DIVER_INVALID_KIND);
        }

    }

}
