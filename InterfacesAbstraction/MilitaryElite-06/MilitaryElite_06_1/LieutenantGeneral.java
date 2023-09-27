package MilitaryElite_06_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class LieutenantGeneral extends Private {

    private final Collection<Private> privates;

    public LieutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {

        StringBuilder lieutenantGeneral = new StringBuilder();

        lieutenantGeneral.append(super.toString());
        lieutenantGeneral.append(System.lineSeparator());
        lieutenantGeneral.append("Privates:");

        if (this.privates.isEmpty())
            return lieutenantGeneral.toString().trim();

        lieutenantGeneral.append(System.lineSeparator());

        // id in descending order
        this.privates.stream().sorted(Comparator.comparingInt(Private::getId).reversed())
                .forEach(priv -> {
                    lieutenantGeneral.append(priv);
                    lieutenantGeneral.append(System.lineSeparator());
                });

        return lieutenantGeneral.toString().trim();
    }

}
