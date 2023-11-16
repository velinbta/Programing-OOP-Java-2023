package christmasPastryShop.repositories;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

public class CocktailRepositoryImpl extends RepositoryImpl<Cocktail> implements CocktailRepository<Cocktail> {

    @Override
    public Cocktail getByName(String name) {
        return this.getAll().stream().filter(cocktail -> cocktail.getName().equals(name)).
                findFirst().orElse(null);
    }

}
