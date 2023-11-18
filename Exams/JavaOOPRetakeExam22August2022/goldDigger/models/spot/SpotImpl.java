package goldDigger.models.spot;

import goldDigger.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class SpotImpl implements Spot {

    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name) {
        this.setName(name);
        this.exhibits = new ArrayList<>();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
