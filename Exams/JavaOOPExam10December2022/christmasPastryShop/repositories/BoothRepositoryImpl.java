package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.BaseBooth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

// BaseBooth only because of OJS
public class BoothRepositoryImpl extends RepositoryImpl<BaseBooth> implements BoothRepository<BaseBooth> {

    @Override
    public BaseBooth getByNumber(int number) {
        return this.getAll().stream().filter(booth -> booth.getBoothNumber() == number).
                findFirst().orElse(null);
    }

}
