package easterRaces.entities.racers;

import easterRaces.common.ExceptionMessage;
import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class RaceImpl implements Race {

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    @Override
    public void addDriver(Driver driver) {

        if (Objects.isNull(driver)) {
            throw new IllegalArgumentException(ExceptionMessage.DRIVER_INVALID);
        }

        if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.DRIVER_NOT_PARTICIPATE_FORMAT,
                    driver.getName()));
        }

        if (this.drivers.contains(driver)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.DRIVER_ALREADY_ADDED_FORMAT,
                    driver.getName(), this.getName()));
        }

        this.drivers.add(driver);
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_NAME_FORMAT,
                    name, 5));
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_NUMBER_OF_LAPS_FORMAT,
                    laps));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return Collections.unmodifiableCollection(this.drivers);
    }

}
