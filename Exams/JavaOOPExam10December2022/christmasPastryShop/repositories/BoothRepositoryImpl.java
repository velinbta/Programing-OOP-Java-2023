package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

public class BoothRepositoryImpl extends RepositoryImpl<Booth> implements BoothRepository<Booth> {

    @Override
    public Booth getByNumber(int number) {
        return this.getAll().stream().filter(booth -> booth.getBoothNumber() == number).
                findFirst().orElse(null);
    }

}
