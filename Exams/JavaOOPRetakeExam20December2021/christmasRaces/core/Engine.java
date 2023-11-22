package christmasRaces.core;

import christmasRaces.common.Command;
import christmasRaces.common.ExceptionMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.io.interfaces.InputReader;
import christmasRaces.io.interfaces.OutputWriter;

import java.io.IOException;

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
            case ADD_DRIVER_TO_RACE: {
                String raceName = data[1];
                String driverName = data[2];
                return this.controller.addDriverToRace(raceName, driverName);
            }
            case START_RACE: {
                String raceName = data[1];
                return this.controller.startRace(raceName);
            }
            case CREATE_DRIVER: {
                String driverName = data[1];
                return this.controller.createDriver(driverName);
            }
            case ADD_CAR_TO_DRIVER: {
                String driverName = data[1];
                String carModel = data[2];
                return this.controller.addCarToDriver(driverName, carModel);
            }
            case CREATE_CAR: {
                String type = data[1];
                String model = data[2];
                int horsePower = Integer.parseInt(data[3]);
                return this.controller.createCar(type, model, horsePower);
            }
            case CREATE_RACE: {
                String raceName = data[0];
                int laps = Integer.parseInt(data[1]);
                return this.controller.createRace(raceName, laps);
            }
            case END:
                return Command.END.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
