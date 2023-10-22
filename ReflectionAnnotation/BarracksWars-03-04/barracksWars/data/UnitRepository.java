package barracksWars.data;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {

    private final Map<String, Integer> amountOfUnits;

    public UnitRepository() {
        this.amountOfUnits = new TreeMap<>();
    }

    @Override
    public void addUnit(Unit unit) {

        String unitType = unit.getClass().getSimpleName();

        if (!this.amountOfUnits.containsKey(unitType)) {
            this.amountOfUnits.put(unitType, 0);
        }

        int newAmount = this.amountOfUnits.get(unitType) + 1;
        this.amountOfUnits.put(unitType, newAmount);

    }

    @Override
    public String getStatistics() {

        StringBuilder statBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
            String formattedEntry = String.format("%s -> %d\n", entry.getKey(), entry.getValue());
            statBuilder.append(formattedEntry);
        }

        return statBuilder.toString().trim();

    }

    @Override
    public boolean removeUnit(String unitType) {

        boolean canRemove = this.amountOfUnits.containsKey(unitType) && this.amountOfUnits.get(unitType) > 0;

        if (canRemove)
            this.amountOfUnits.put(unitType, this.amountOfUnits.get(unitType) - 1);

        return canRemove;
    }

}
