package goldDigger.core;

import goldDigger.common.Command;
import goldDigger.common.ExceptionMessages;

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
            case ADD_DISCOVERER: {
                String kind = data[1];
                String discovererName = data[2];
                return this.controller.addDiscoverer(kind, discovererName);
            }
            case ADD_SPOT: {
                String spotName = data[1];
                String[] exhibits = Arrays.stream(data).skip(2).toArray(String[]::new);
                return this.controller.addSpot(spotName, exhibits);
            }
            case EXCLUDE_DISCOVERER: {
                String discovererName = data[1];
                return this.controller.excludeDiscoverer(discovererName);
            }
            case INSPECT_SPOT: {
                String spotName = data[1];
                return this.controller.inspectSpot(spotName);
            }
            case GET_STATISTICS:
                return this.controller.getStatistics();
            case EXIT:
                return Command.EXIT.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.COMMAND_DOES_NOT_EXIST,
                        commandAsString));
        }

    }

}
