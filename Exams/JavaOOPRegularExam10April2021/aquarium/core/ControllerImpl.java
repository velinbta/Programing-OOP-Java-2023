package aquarium.core;

import aquarium.common.ConstantMessage;
import aquarium.common.ExceptionMessage;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository decorationRepository;
    private Map<String, Aquarium> aquariumsByName;

    public ControllerImpl() {
        this.decorationRepository = new DecorationRepository();
        this.aquariumsByName = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {

        Aquarium newAquarium = this.getAquariumByType(aquariumType, aquariumName);
        this.aquariumsByName.put(aquariumName, newAquarium);

        return String.format(ConstantMessage.SUCCESSFULLY_ADDED_AQUARIUM_TYPE_FORMAT, aquariumType);
    }

    @Override
    public String addDecoration(String type) {

        Decoration newDecoration = this.getDecorationByType(type);
        this.decorationRepository.add(newDecoration);

        return String.format(ConstantMessage.SUCCESSFULLY_ADDED_DECORATION_TYPE_FORMAT, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {

        Decoration decorationByType = this.decorationRepository.findByType(decorationType);

        if (Objects.isNull(decorationByType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.NO_DECORATION_FOUND,
                    decorationType));
        }

        this.aquariumsByName.get(aquariumName).addDecoration(decorationByType);
        this.decorationRepository.remove(decorationByType);

        return String.format(ConstantMessage.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM_FORMAT,
                decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName,
                          String fishSpecies, double price) {

        Fish newFish = this.getFishByType(fishType, fishName, fishSpecies, price);
        Aquarium aquariumByName = this.aquariumsByName.get(aquariumName);

        if (!this.fishCanLiveInAquarium(fishType, aquariumByName)) {
            return ConstantMessage.WATER_NOT_SUITABLE;
        }

        aquariumByName.addFish(newFish);

        return String.format(ConstantMessage.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM_FORMAT, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {

        Aquarium aquariumByName = this.aquariumsByName.get(aquariumName);
        aquariumByName.feed();

        return String.format(ConstantMessage.FISH_FED_FORMAT, aquariumByName.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {

        Aquarium aquariumByName = this.aquariumsByName.get(aquariumName);

        double decorationTotalPrice = aquariumByName.getDecorations().stream().
                mapToDouble(Decoration::getPrice).sum();
        double fishTotalPrice = aquariumByName.getFish().stream().
                mapToDouble(Fish::getPrice).sum();

        double totalAquariumValue = decorationTotalPrice + fishTotalPrice;

        return String.format(ConstantMessage.VALUE_AQUARIUM_FORMAT, aquariumName, totalAquariumValue);
    }

    @Override
    public String report() {

        StringBuilder report = new StringBuilder();

        this.aquariumsByName.values().stream().map(Aquarium::getInfo).forEach(aquarium -> {
            report.append(aquarium);
            report.append(System.lineSeparator());
        });

        return report.toString().trim();
    }

    private boolean fishCanLiveInAquarium(String fishType, Aquarium aquariumByName) {

        String aquariumType = aquariumByName.getClass().getSimpleName();

        return fishType.equals("FreshwaterFish") && aquariumType.equals("FreshwaterAquarium") ||
                fishType.equals("SaltwaterFish") && aquariumType.equals("SaltwaterAquarium");
    }

    private Aquarium getAquariumByType(String aquariumType, String aquariumName) {

        switch (aquariumType) {

            case "FreshwaterAquarium":
                return new FreshwaterAquarium(aquariumName);
            case "SaltwaterAquarium":
                return new SaltwaterAquarium(aquariumName);
            default:
                throw new NullPointerException(ExceptionMessage.INVALID_AQUARIUM_TYPE);
        }

    }

    private Decoration getDecorationByType(String type) {

        switch (type) {

            case "Ornament":
                return new Ornament();
            case "Plant":
                return new Plant();
            default:
                throw new IllegalArgumentException(ExceptionMessage.INVALID_DECORATION_TYPE);
        }

    }

    private Fish getFishByType(String fishType, String fishName, String fishSpecies, double price) {

        switch (fishType) {

            case "FreshwaterFish":
                return new FreshwaterFish(fishName, fishSpecies, price);
            case "SaltwaterFish":
                return new SaltwaterFish(fishName, fishSpecies, price);
            default:
                throw new IllegalArgumentException(ExceptionMessage.INVALID_FISH_TYPE);
        }

    }

}
