package restaurant;

import restaurant.core.ControllerImpl;
import restaurant.core.Engine;
import restaurant.core.Controller;
import restaurant.entity.drink.Beverages;
import restaurant.entity.food.HealthyFood;
import restaurant.entity.table.Table;

import restaurant.io.ConsoleReader;
import restaurant.io.ConsoleWriter;
import restaurant.repository.*;

public class Main {
    public static void main(String[] args) {

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        Engine engine = new Engine(reader, writer, controller);
        engine.run();

    }

}
