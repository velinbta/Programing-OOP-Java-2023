package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

public class AddCommand extends BaseCommand {

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {

        String unitType = this.getData()[1];

        Unit createdUnit = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(createdUnit);

        return String.format("%s added!", unitType);

    }

}
