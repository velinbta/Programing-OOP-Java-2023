package christmasRaces.core;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Comparator;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository,
                          Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {

        if (Objects.nonNull(this.driverRepository.getByName(driverName))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS_FORMAT, driverName));
        }

        Driver newDriver = new DriverImpl(driverName);
        this.driverRepository.add(newDriver);

        return String.format(OutputMessages.DRIVER_CREATED_FORMAT, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        if (Objects.nonNull(this.carRepository.getByName(model))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS_FORMAT, model));
        }

        Car newCar = type.equals("Muscle") // Guaranteed either Muscle or Sports
                ? new MuscleCar(model, horsePower)
                : new SportsCar(model, horsePower);

        this.carRepository.add(newCar);

        return String.format(OutputMessages.CAR_CREATED_FORMAT, newCar.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driverByName = this.driverRepository.getByName(driverName);

        if (Objects.isNull(driverByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND_FORMAT, driverName));
        }

        Car carByName = this.carRepository.getByName(carModel);

        if (Objects.isNull(carByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND_FORMAT, carModel));
        }

        driverByName.addCar(carByName);

        return String.format(OutputMessages.CAR_ADDED_FORMAT, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race raceByName = this.raceRepository.getByName(raceName);

        if (Objects.isNull(raceByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND_FORMAT, raceName));
        }

        Driver driverByName = this.driverRepository.getByName(driverName);

        if (Objects.isNull(driverByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND_FORMAT, driverName));
        }

        raceByName.addDriver(driverByName);

        return String.format(OutputMessages.DRIVER_ADDED_FORMAT, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {

        if (Objects.nonNull(this.raceRepository.getByName(name))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS_FORMAT, name));
        }

        Race newRace = new RaceImpl(name, laps);

        this.raceRepository.add(newRace);

        return String.format(OutputMessages.RACE_CREATED_FORMAT, name);
    }

    @Override
    public String startRace(String raceName) {

        Race raceByName = this.raceRepository.getByName(raceName);

        if (Objects.isNull(raceByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND_FORMAT, raceName));
        }

        if (raceByName.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID_FORMAT, raceName, 3));
        }

        this.raceRepository.remove(raceByName);

        Comparator<Driver> racePointsReversedComparator = this.getDriverRacePointsReversedComparator();

        String[] winnersNames = raceByName.getDrivers().stream().sorted(racePointsReversedComparator).
                limit(3).map(Driver::getName).toArray(String[]::new);

        return this.getWinnersOutput(winnersNames, raceName);
    }

    private Comparator<Driver> getDriverRacePointsReversedComparator() {
        return (first, second) -> {

            double firstRacePoints = first.getCar().calculateRacePoints(1);
            double secondRacePoints = second.getCar().calculateRacePoints(1);

            return Double.compare(secondRacePoints, firstRacePoints);
        };
    }

    @SuppressWarnings("all")
    private String getWinnersOutput(String[] winners, String raceName) {

        StringBuilder winnersOutput = new StringBuilder();

        winnersOutput.append(String.format(OutputMessages.DRIVER_FIRST_POSITION_FORMAT, winners[0], raceName));
        winnersOutput.append(System.lineSeparator());

        winnersOutput.append(String.format(OutputMessages.DRIVER_SECOND_POSITION_FORMAT, winners[1], raceName));
        winnersOutput.append(System.lineSeparator());

        winnersOutput.append(String.format(OutputMessages.DRIVER_THIRD_POSITION_FORMAT, winners[2], raceName));

        return winnersOutput.toString().trim();
    }

}
