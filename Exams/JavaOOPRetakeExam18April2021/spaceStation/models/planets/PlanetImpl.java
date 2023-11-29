package spaceStation.models.planets;

import spaceStation.common.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class PlanetImpl implements Planet {

    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
        this.setName(name);
        this.items = new ArrayList<>();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
