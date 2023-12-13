package easterRaces.core;

public interface Controller {

    String createDriver(String driverName);

    String createCar(String type, String model, int horsePower);

    String addCarToDriver(String driverName, String carModel);

    String addDriverToRace(String raceName, String driverName);

    String startRace(String raceName);

    String createRace(String raceName, int laps);

}
