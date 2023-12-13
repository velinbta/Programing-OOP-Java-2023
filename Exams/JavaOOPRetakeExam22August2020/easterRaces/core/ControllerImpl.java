package easterRaces.core;

import easterRaces.common.ExceptionMessage;
import easterRaces.common.OutputMessage;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.Repository;

import java.util.*;

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
            throw new IllegalArgumentException(String.format(ExceptionMessage.DRIVER_EXISTS_FORMAT, driverName));
        }

        Driver newDriver = new DriverImpl(driverName);
        this.driverRepository.add(newDriver);

        return String.format(OutputMessage.DRIVER_CREATED_FORMAT, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        if (Objects.nonNull(this.carRepository.getByName(model))) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.CAR_EXISTS_FORMAT, model));
        }

        Car newCar = type.equals("Muscle")
                ? new MuscleCar(model, horsePower)
                : new SportsCar(model, horsePower);

        this.carRepository.add(newCar);

        return String.format(OutputMessage.CAR_CREATED_FORMAT, newCar.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driverByName = this.driverRepository.getByName(driverName);

        if (Objects.isNull(driverByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.DRIVER_NOT_FOUND_FORMAT,
                    driverName));
        }

        Car carByName = this.carRepository.getByName(carModel);

        if (Objects.isNull(carByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.CAR_NOT_FOUND_FORMAT,
                    carModel));
        }

        driverByName.addCar(carByName);

        return String.format(OutputMessage.CAR_ADDED_FORMAT, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race raceByName = this.raceRepository.getByName(raceName);

        if (Objects.isNull(raceByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.RACE_NOT_FOUND_FORMAT,
                    raceName));
        }

        Driver driverByName = this.driverRepository.getByName(driverName);

        if (Objects.isNull(driverByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.DRIVER_NOT_FOUND_FORMAT,
                    driverName));
        }

        raceByName.addDriver(driverByName);

        return String.format(OutputMessage.DRIVER_ADDED_FORMAT, driverName, raceName);
    }

    @Override
    public String createRace(String raceName, int laps) {

        if (Objects.nonNull(this.raceRepository.getByName(raceName))) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.RACE_EXISTS_FORMAT, raceName));
        }

        Race newRace = new RaceImpl(raceName, laps);

        this.raceRepository.add(newRace);

        return String.format(OutputMessage.RACE_CREATED_FORMAT, raceName);
    }

    @Override
    public String startRace(String raceName) {

        Race raceByName = this.raceRepository.getByName(raceName);

        if (Objects.isNull(raceByName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.RACE_NOT_FOUND_FORMAT,
                    raceName));
        }

        if (raceByName.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.RACE_INVALID_FORMAT,
                    raceName, 3));
        }

        this.raceRepository.remove(raceByName);

        return this.getWinnersOutput(raceByName);
    }

    @SuppressWarnings("all")
    private String getWinnersOutput(Race race) {

        Comparator<Driver> racePointsComparator = (firstDriver, secondDriver) -> {
            double firstDriverPoints = firstDriver.getCar().calculateRacePoints(race.getLaps());
            double secondDriverPoints = secondDriver.getCar().calculateRacePoints(race.getLaps());
            return Double.compare(secondDriverPoints, firstDriverPoints);
        };

        String[] winnersNames = race.getDrivers().stream().sorted(racePointsComparator).
                limit(3).map(Driver::getName).toArray(String[]::new);

        String raceName = race.getName();
        String firstPlace = winnersNames[0];
        String secondPlace = winnersNames[1];
        String thirdPlace = winnersNames[2];

        this.driverRepository.getByName(firstPlace).winRace();

        StringBuilder winnersOutput = new StringBuilder();

        winnersOutput.append(String.format(OutputMessage.DRIVER_FIRST_POSITION_FORMAT,
                firstPlace, raceName)).append(System.lineSeparator());

        winnersOutput.append(String.format(OutputMessage.DRIVER_SECOND_POSITION_FORMAT,
                secondPlace, raceName)).append(System.lineSeparator());

        winnersOutput.append(String.format(OutputMessage.DRIVER_THIRD_POSITION_FORMAT,
                thirdPlace, raceName));

        return winnersOutput.toString().trim();
    }

}
