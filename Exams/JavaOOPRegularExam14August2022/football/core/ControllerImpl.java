package football.core;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private SupplementRepository supplementRepository;
    private Map<String, Field> fieldsByName;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fieldsByName = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {

        Field newField = this.getField(fieldType, fieldName);
        this.fieldsByName.putIfAbsent(fieldName, newField);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {

        Supplement newSupplement = this.getSupplement(type);
        this.supplementRepository.add(newSupplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Field field = this.fieldsByName.get(fieldName);

        Supplement supplementByType = this.supplementRepository.findByType(supplementType);

        if (Objects.isNull(supplementByType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        field.addSupplement(supplementByType);
        this.supplementRepository.remove(supplementByType);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName,
                            String nationality, int strength) {

        Player newPlayer = this.getPlayer(playerType, playerName, nationality, strength);

        Field field = this.fieldsByName.get(fieldName);

        if (!this.playerCanPlay(playerType, field)) {
            return ExceptionMessages.FIELD_NOT_SUITABLE;
        }

        field.addPlayer(newPlayer);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {

        Field field = this.fieldsByName.get(fieldName);

        field.drag();

        return String.format(ConstantMessages.PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {

        Field field = this.fieldsByName.get(fieldName);
        int playersTotalStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();

        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, playersTotalStrength);
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        this.fieldsByName.values().forEach(field -> {
            statistics.append(field.getInfo());
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private boolean playerCanPlay(String playerType, Field field) {

        String fieldType = field.getClass().getSimpleName();

        return playerType.equals("Women") && fieldType.equals("ArtificialTurf") ||
                playerType.equals("Men") && fieldType.equals("NaturalGrass");

    }

    private Field getField(String fieldType, String fieldName) {

        switch (fieldType) {

            case "ArtificialTurf":
                return new ArtificialTurf(fieldName);
            case "NaturalGrass":
                return new NaturalGrass(fieldName);
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }

    }

    private Supplement getSupplement(String type) {

        switch (type) {

            case "Powdered":
                return new Powdered();
            case "Liquid":
                return new Liquid();
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

    }

    private Player getPlayer(String playerType, String playerName, String nationality, int strength) {

        switch (playerType) {

            case "Men":
                return new Men(playerName, nationality, strength);
            case "Women":
                return new Women(playerName, nationality, strength);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

    }

}
