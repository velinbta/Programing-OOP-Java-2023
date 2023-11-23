package glacialExpedition.models.states;

import glacialExpedition.common.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class StateImpl implements State {

    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        this.setName(name);
        this.exhibits = new ArrayList<>();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

}
