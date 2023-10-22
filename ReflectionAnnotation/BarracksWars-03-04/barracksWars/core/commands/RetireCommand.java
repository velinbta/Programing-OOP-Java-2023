package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class RetireCommand extends BaseCommand {

    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {

        String unitType = this.getData()[1];

        return this.getRepository().removeUnit(unitType) // <- boolean based result
                ? String.format("%s retired!", unitType)
                : "No such units in repository.";

    }

}
