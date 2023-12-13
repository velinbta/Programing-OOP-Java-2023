package easterRaces;

import easterRaces.core.Controller;
import easterRaces.core.ControllerImpl;
import easterRaces.core.Engine;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.racers.Race;
import easterRaces.io.ConsoleReader;
import easterRaces.io.ConsoleWriter;
import easterRaces.io.InputReader;
import easterRaces.io.OutputWriter;
import easterRaces.repositories.CarRepository;
import easterRaces.repositories.DriverRepository;
import easterRaces.repositories.RaceRepository;
import easterRaces.repositories.Repository;

public class Main {

    public static void main(String[] args) {

        Repository<Driver> driverRepository = new DriverRepository();
        Repository<Car> carRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();

        Controller controller = new ControllerImpl(driverRepository, carRepository, raceRepository);

        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();

        Engine engine = new Engine(reader, writer, controller);
        engine.run();

    }

}
