package zoo.core;

import zoo.common.Command;
import zoo.common.ExceptionMessages;

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
            case ADD_AREA: {
                String areaType = data[1];
                String areaName = data[2];
                return this.controller.addArea(areaType, areaName);
            }
            case BUY_FOOD: {
                String foodType = data[1];
                return this.controller.buyFood(foodType);
            }
            case FOOD_FOR_AREA: {
                String areaName = data[1];
                String foodType = data[2];
                return this.controller.foodForArea(areaName, foodType);
            }
            case ADD_ANIMAL: {
                String areaName = data[1];
                String animalType = data[2];
                String animalName = data[3];
                String kind = data[4];
                double price = Double.parseDouble(data[5]);
                return this.controller.addAnimal(areaName, animalType, animalName, kind, price);
            }
            case FEED_ANIMAL: {
                String areaName = data[1];
                return this.controller.feedAnimal(areaName);
            }
            case CALCULATE_KG: {
                String areaName = data[1];
                return this.controller.calculateKg(areaName);
            }
            case GET_STATISTICS:
                return this.controller.getStatistics();
            case EXIT:
                return Command.EXIT.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND,
                        commandAsString));
        }

    }

}