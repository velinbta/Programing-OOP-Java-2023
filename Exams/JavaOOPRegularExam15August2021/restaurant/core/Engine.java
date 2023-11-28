package restaurant.core;

import restaurant.common.Command;
import restaurant.common.ExceptionMessage;
import restaurant.io.ConsoleReader;
import restaurant.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class Engine implements Runnable {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private Controller controller;

    public Engine(ConsoleReader reader, ConsoleWriter writer, Controller controller) {
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
            case ADD_HEALTHY_FOOD: {
                String type = data[1];
                double price = Double.parseDouble(data[2]);
                String name = data[3];
                return this.controller.addHealthyFood(type, price, name);
            }
            case ADD_BEVERAGE: {
                String type = data[1];
                int counter = Integer.parseInt(data[2]);
                String brand = data[3];
                String name = data[4];
                return this.controller.addBeverage(type, counter, brand, name);
            }
            case ADD_TABLE: {
                String type = data[1];
                int number = Integer.parseInt(data[2]);
                int size = Integer.parseInt(data[3]);
                return this.controller.addTable(type, number, size);
            }
            case RESERVE: {
                int numberOfPeople = Integer.parseInt(data[1]);
                return this.controller.reserve(numberOfPeople);
            }
            case ORDER_HEALTHY_FOOD: {
                int tableNumber = Integer.parseInt(data[1]);
                String healthyFoodName = data[2];
                return this.controller.orderHealthyFood(tableNumber, healthyFoodName);
            }
            case ORDER_BEVERAGE: {
                int tableNumber = Integer.parseInt(data[1]);
                String name = data[2];
                String brand = data[3];
                return this.controller.orderBeverage(tableNumber, name, brand);
            }
            case CLOSED_BILL: {
                int tableNumber = Integer.parseInt(data[1]);
                return this.controller.closedBill(tableNumber);
            }
            case TOTAL_MONEY:
                return this.controller.totalMoney();
            case END:
                return Command.END.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
