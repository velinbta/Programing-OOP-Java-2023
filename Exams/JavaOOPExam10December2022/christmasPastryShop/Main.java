package christmasPastryShop;

import christmasPastryShop.core.ControllerImpl;
import christmasPastryShop.core.EngineImpl;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.core.interfaces.Engine;
import christmasPastryShop.entities.booths.BaseBooth;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.io.ConsoleReader;
import christmasPastryShop.io.ConsoleWriter;
import christmasPastryShop.repositories.BoothRepositoryImpl;
import christmasPastryShop.repositories.CocktailRepositoryImpl;
import christmasPastryShop.repositories.DelicacyRepositoryImpl;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class Main {

    public static void main(String[] args) {

        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl();
        CocktailRepository<Cocktail> cocktailRepository = new CocktailRepositoryImpl();
        BoothRepository<BaseBooth> boothRepository = new BoothRepositoryImpl();

        Controller controller = new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();

        Engine engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }

}
