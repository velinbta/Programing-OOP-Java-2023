package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("FieldMayBeFinal")
public class Backpack implements Bag {

    private Collection<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

}
