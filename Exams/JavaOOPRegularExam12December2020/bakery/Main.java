package bakery;

import bakery.core.Controller;
import bakery.core.ControllerImpl;
import bakery.core.Engine;
import bakery.entities.bakedFoods.BakedFood;
import bakery.entities.drinks.Drink;
import bakery.entities.tables.Table;

import bakery.io.ConsoleReader;
import bakery.io.ConsoleWriter;
import bakery.io.InputReader;
import bakery.io.OutputWriter;
import bakery.repositories.*;

public class Main {
    public static void main(String[] args) {

        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();

        Engine engine = new Engine(reader, writer, controller);
        engine.run();

    }

}
