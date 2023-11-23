package glacialExpedition.core;

import glacialExpedition.common.Command;
import glacialExpedition.common.ExceptionMessage;

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
            case ADD_EXPLORER: {
                String explorerType = data[1];
                String explorerName = data[2];
                return controller.addExplorer(explorerType, explorerName);
            }
            case ADD_STATE: {
                String stateName = data[1];
                String[] exhibits = Arrays.stream(data).skip(2).toArray(String[]::new);
                return controller.addState(stateName, exhibits);
            }
            case RETIRE_EXPLORER: {
                String explorerName = data[1];
                return controller.retireExplorer(explorerName);
            }
            case EXPLORE_STATE: {
                String stateName = data[1];
                return controller.exploreState(stateName);
            }
            case FINAL_RESULT:
                return controller.finalResult();
            case EXIT:
                return Command.EXIT.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
