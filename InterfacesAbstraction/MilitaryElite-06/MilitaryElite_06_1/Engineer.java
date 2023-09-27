package MilitaryElite_06_1;

import java.util.ArrayList;
import java.util.Collection;

public class Engineer extends SpecialisedSoldier {

    private final Collection<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {

        StringBuilder engineer = new StringBuilder();
        engineer.append(super.toString());
        engineer.append(System.lineSeparator());
        engineer.append("Repairs:");

        if (this.repairs.isEmpty()) {
            return engineer.toString().trim();
        }

        engineer.append(System.lineSeparator());

        this.repairs.forEach(repair -> {
            engineer.append(repair);
            engineer.append(System.lineSeparator());
        });

        return engineer.toString().trim();
    }

}
