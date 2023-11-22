package catHouse.core;

import catHouse.common.Command;
import catHouse.common.ExceptionMessage;

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

                if (result.equals(Command.END.name())) {
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
            case ADD_HOUSE: {
                String houseType = data[1];
                String houseName = data[2];
                return this.controller.addHouse(houseType, houseName);
            }
            case BUY_TOY: {
                String toyType = data[1];
                return this.controller.buyToy(toyType);
            }
            case TOY_FOR_HOUSE: {
                String houseName = data[1];
                String toyType = data[2];
                return this.controller.toyForHouse(houseName, toyType);
            }
            case ADD_CAT: {
                String houseName = data[1];
                String catType = data[2];
                String catName = data[3];
                String catBreed = data[4];
                double price = Double.parseDouble(data[5]);
                return this.controller.addCat(houseName, catType, catName, catBreed, price);
            }
            case FEEDING_CAT: {
                String houseName = data[1];
                return this.controller.feedingCat(houseName);
            }
            case SUM_OF_ALL: {
                String houseName = data[1];
                return this.controller.sumOfAll(houseName);
            }
            case STATISTICS:
                return this.controller.getStatistics();
            case END:
                return Command.END.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}

