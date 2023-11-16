package christmasPastryShop.repositories;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class DelicacyRepositoryImpl extends RepositoryImpl<Delicacy> implements DelicacyRepository<Delicacy> {

    @Override
    public Delicacy getByName(String name) {
        return this.getAll().stream().filter(delicacy -> delicacy.getName().equals(name))
                .findFirst().orElse(null);
    }

}
