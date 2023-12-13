package easterRaces.core;

import easterRaces.common.Command;
import easterRaces.common.ExceptionMessage;
import easterRaces.io.InputReader;
import easterRaces.io.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Controller controller;

    public Engine(InputReader reader, OutputWriter writer, Controller controller) {
        this.reader = reader;
        this.writer = writer;
        this.controller = controller;
    }

    @Override
    public void run() {

        while (true) {

            String result;

            try {

                result = processInput();

                if (result.equals(Command.END.name())) {
                    break;
                }

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }

            this.writer.writeLine(result);
        }

    }

    private String processInput() throws IOException {

        String input = this.reader.readLine();
        String[] data = input.split("\\s+");

        String commandAsString = data[0];
        Command command = Command.parseCommand(commandAsString);

        switch (command) {
            case CREATE_DRIVER: {
                String driverName = data[1];
                return this.controller.createDriver(driverName);
            }
            case CREATE_CAR: {
                String type = data[1];
                String model = data[2];
                int horsePower = Integer.parseInt(data[3]);
                return this.controller.createCar(type, model, horsePower);
            }
            case ADD_CAR_TO_DRIVER: {
                String driverName = data[1];
                String carModel = data[2];
                return this.controller.addCarToDriver(driverName, carModel);
            }
            case ADD_DRIVER_TO_RACE: {
                String raceName = data[1];
                String driverName = data[2];
                return this.controller.addDriverToRace(raceName, driverName);
            }
            case CREATE_RACE: {
                String raceName = data[1];
                int laps = Integer.parseInt(data[2]);
                return this.controller.createRace(raceName, laps);
            }
            case START_RACE: {
                String raceName = data[1];
                return this.controller.startRace(raceName);
            }
            case END:
                return Command.END.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
