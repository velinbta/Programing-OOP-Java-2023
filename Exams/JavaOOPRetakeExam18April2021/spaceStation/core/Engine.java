package spaceStation.core;

import spaceStation.common.Command;
import spaceStation.common.ExceptionMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class Engine implements Runnable {

    private Controller controller;
    private BufferedReader reader;

    public Engine(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        while (true) {

            String result;

            try {

                result = processInput();

                if (result.equals(Command.EXIT.name())) {
                    break;
                }

            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }

    }

    private String processInput() throws IOException {

        String input = this.reader.readLine();
        String[] data = input.split("\\s+");

        String commandAsString = data[0];
        Command command = Command.parseCommand(commandAsString);

        switch (command) {
            case ADD_ASTRONAUT: {
                String type = data[1];
                String astronautName = data[2];
                return this.controller.addAstronaut(type, astronautName);
            }
            case ADD_PLANET: {
                String planetName = data[1];
                String[] items = Arrays.stream(data).skip(2).toArray(String[]::new);
                return this.controller.addPlanet(planetName, items);
            }
            case RETIRE_ASTRONAUT: {
                String astronautName = data[1];
                return this.controller.retireAstronaut(astronautName);
            }
            case EXPLORE_PLANET: {
                String planetName = data[1];
                return this.controller.explorePlanet(planetName);
            }
            case REPORT:
                return this.controller.report();
            case EXIT:
                return Command.EXIT.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
