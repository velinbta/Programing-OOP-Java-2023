package football.core;

import football.common.Command;
import football.common.ExceptionMessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        Command command = Command.parse(commandAsString);

        switch (command) {
            case ADD_FIELD: {
                String fieldType = data[1];
                String fieldName = data[2];
                return this.controller.addField(fieldType, fieldName);
            }
            case DELIVERY_SUPPLEMENT: {
                String supplementType = data[1];
                return this.controller.deliverySupplement(supplementType);
            }
            case SUPPLEMENT_FOR_FIELD: {
                String fieldName = data[1];
                String supplementType = data[2];
                return this.controller.supplementForField(fieldName, supplementType);
            }
            case ADD_PLAYER: {
                String fieldName = data[1];
                String playerType = data[2];
                String playerName = data[3];
                String nationality = data[4];
                int strength = Integer.parseInt(data[5]);
                return this.controller.addPlayer(fieldName, playerType, playerName, nationality, strength);
            }
            case DRAG_PLAYER: {
                String fieldName = data[1];
                return this.controller.dragPlayer(fieldName);
            }
            case CALCULATE_STRENGTH: {
                String fieldName = data[1];
                return this.controller.calculateStrength(fieldName);
            }
            case GET_STATISTICS:
                return this.controller.getStatistics();
            case EXIT:
                return Command.EXIT.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND_NAME,
                        commandAsString));
        }

    }

}
