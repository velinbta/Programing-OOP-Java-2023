package aquarium.core;

import aquarium.common.Command;
import aquarium.common.ExceptionMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class Engine implements Runnable {

    private Controller controller;
    private BufferedReader reader;

    public Engine() {
        this.controller = new ControllerImpl();
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

            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
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
            case ADD_AQUARIUM: {
                String aquariumType = data[1];
                String aquariumName = data[2];
                return this.controller.addAquarium(aquariumType, aquariumName);
            }
            case ADD_DECORATION: {
                String decorationType = data[1];
                return this.controller.addDecoration(decorationType);
            }
            case INSERT_DECORATION: {
                String aquariumName = data[1];
                String decorationType = data[2];
                return this.controller.insertDecoration(aquariumName, decorationType);
            }
            case ADD_FISH: {
                String aquariumName = data[1];
                String fishType = data[2];
                String fishName = data[3];
                String fishSpecies = data[4];
                double price = Double.parseDouble(data[5]);
                return this.controller.addFish(aquariumName, fishType, fishName, fishSpecies, price);
            }
            case FEED_FISH: {
                String aquariumName = data[1];
                return this.controller.feedFish(aquariumName);
            }
            case CALCULATE_VALUE: {
                String aquariumName = data[1];
                return this.controller.calculateValue(aquariumName);
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

