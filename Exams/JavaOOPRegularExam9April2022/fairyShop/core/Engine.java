package fairyShop.core;

import fairyShop.common.Command;
import fairyShop.common.ExceptionMessages;

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
            case ADD_HELPER: {
                String helperType = data[1];
                String helperName = data[2];
                return this.controller.addHelper(helperType, helperName);
            }
            case ADD_PRESENT: {
                String presentName = data[1];
                int energyRequired = Integer.parseInt(data[2]);
                return this.controller.addPresent(presentName, energyRequired);
            }
            case ADD_INSTRUMENT_TO_HELPER: {
                String helperName = data[1];
                int power = Integer.parseInt(data[2]);
                return this.controller.addInstrumentToHelper(helperName, power);
            }
            case CRAFT_PRESENT: {
                String presentName = data[1];
                return this.controller.craftPresent(presentName);
            }
            case REPORT:
                return this.controller.report();
            case EXIT:
                return Command.EXIT.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND,
                        commandAsString));
        }

    }

}
