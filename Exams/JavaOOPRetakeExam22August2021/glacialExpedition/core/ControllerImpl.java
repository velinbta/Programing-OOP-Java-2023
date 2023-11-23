package glacialExpedition.core;

import glacialExpedition.common.ConstantMessage;
import glacialExpedition.common.ExceptionMessage;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private Mission mission;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addExplorer(String explorerType, String explorerName) {

        Explorer newExplorer = this.getExplorerByType(explorerType, explorerName);
        this.explorerRepository.add(newExplorer);

        return String.format(ConstantMessage.EXPLORER_ADDED_FORMAT, explorerType, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {

        State newState = new StateImpl(stateName);
        Arrays.stream(exhibits).forEach(exhibit -> newState.getExhibits().add(exhibit));

        this.stateRepository.add(newState);

        return String.format(ConstantMessage.STATE_ADDED_FORMAT, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {

        Explorer explorerByName = this.explorerRepository.byName(explorerName);

        if (Objects.isNull(explorerByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.EXPLORER_DOES_NOT_EXIST_FORMAT,
                    explorerName));
        }

        this.explorerRepository.remove(explorerByName);

        return String.format(ConstantMessage.EXPLORER_RETIRED_FORMAT, explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        Collection<Explorer> suitableExplorers = this.explorerRepository.getCollection().stream().
                filter(explorer -> explorer.getEnergy() > 50D).collect(Collectors.toList());

        if (suitableExplorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.STATE_EXPLORERS_DOES_NOT_EXIST);
        }

        State stateToExplore = this.stateRepository.byName(stateName);
        this.mission.explore(stateToExplore, suitableExplorers);

        int retiredExplorers = (int) suitableExplorers.stream().filter(explorer ->
                !explorer.canSearch()).count();

        this.exploredStatesCount++;

        return String.format(ConstantMessage.STATE_EXPLORED_FORMAT, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {

        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format(ConstantMessage.FINAL_STATE_EXPLORED_FORMAT, this.exploredStatesCount));
        statistics.append(System.lineSeparator());

        statistics.append(ConstantMessage.FINAL_EXPLORER_INFO);
        statistics.append(System.lineSeparator());

        this.explorerRepository.getCollection().forEach(explorer -> {
            statistics.append(explorer);
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private Explorer getExplorerByType(String explorerType, String explorerName) {

        switch (explorerType) {

            case "AnimalExplorer":
                return new AnimalExplorer(explorerName);
            case "GlacierExplorer":
                return new GlacierExplorer(explorerName);
            case "NaturalExplorer":
                return new NaturalExplorer(explorerName);
            default:
                throw new IllegalArgumentException(ExceptionMessage.EXPLORER_INVALID_TYPE);
        }

    }

}
