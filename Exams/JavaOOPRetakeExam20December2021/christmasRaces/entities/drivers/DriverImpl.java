package christmasRaces.entities.drivers;

import christmasRaces.common.ExceptionMessage;
import christmasRaces.entities.cars.Car;

import java.util.Objects;

public class DriverImpl implements Driver {

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_NAME_FORMAT, name, 5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (Objects.isNull(car)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_INVALID);
        }
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }

}
