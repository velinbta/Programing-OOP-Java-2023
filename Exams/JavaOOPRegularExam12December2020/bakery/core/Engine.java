package bakery.core;

import bakery.common.Command;
import bakery.common.ExceptionMessage;
import bakery.io.InputReader;
import bakery.io.OutputWriter;

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
            case ADD_DRINK: {
                String type = data[1];
                String name = data[2];
                int portion = Integer.parseInt(data[3]);
                String brand = data[4];
                return this.controller.addDrink(type, name, portion, brand);
            }
            case ADD_FOOD: {
                String type = data[1];
                String name = data[2];
                double price = Double.parseDouble(data[3]);
                return this.controller.addFood(type, name, price);
            }
            case ADD_TABLE: {
                String type = data[1];
                int tableNumber = Integer.parseInt(data[2]);
                int capacity = Integer.parseInt(data[3]);
                return this.controller.addTable(type, tableNumber, capacity);
            }
            case RESERVE_TABLE: {
                int numberOfPeople = Integer.parseInt(data[1]);
                return this.controller.reserveTable(numberOfPeople);
            }
            case ORDER_DRINK: {
                int tableNumber = Integer.parseInt(data[1]);
                String drinkName = data[2];
                String drinkBrand = data[3];
                return this.controller.orderDrink(tableNumber, drinkName, drinkBrand);
            }
            case ORDER_FOOD: {
                int tableNumber = Integer.parseInt(data[1]);
                String foodName = data[2];
                return this.controller.orderFood(tableNumber, foodName);
            }
            case LEAVE_TABLE: {
                int tableNumber = Integer.parseInt(data[1]);
                return this.controller.leaveTable(tableNumber);
            }
            case GET_FREE_TABLES_INFO:
                return this.controller.getFreeTablesInfo();
            case GET_TOTAL_INCOME:
                return this.controller.getTotalIncome();
            case END:
                return Command.END.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
