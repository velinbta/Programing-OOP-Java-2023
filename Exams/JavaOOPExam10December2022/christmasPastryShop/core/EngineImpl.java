package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.enums.Command;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.core.interfaces.Engine;
import christmasPastryShop.io.ConsoleReader;
import christmasPastryShop.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class EngineImpl implements Engine {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private Controller controller;

    public EngineImpl(ConsoleReader reader, ConsoleWriter writer, Controller controller) {
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
        String[] tokens = input.split("\\s+");

        Command command = Command.parseCommand(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case ADD_DELICACY: {
                String delicacyType = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                return this.controller.addDelicacy(delicacyType, name, price);
            }
            case ADD_COCKTAIL: {
                String cocktailType = data[0];
                String name = data[1];
                int portion = Integer.parseInt(data[2]);
                String brand = data[3];
                return this.controller.addCocktail(cocktailType, name, portion, brand);
            }
            case ADD_BOOTH: {
                String boothType = data[0];
                int tableNumber = Integer.parseInt(data[1]);
                int capacity = Integer.parseInt(data[2]);
                return this.controller.addBooth(boothType, tableNumber, capacity);
            }
            case RESERVE_BOOTH: {
                int numberOfPeople = Integer.parseInt(data[0]);
                return this.controller.reserveBooth(numberOfPeople);
            }
            case ORDER_COCKTAIL: {
                int tableNumber = Integer.parseInt(data[0]);
                String drinkName = data[1];
                String drinkBrand = data[2];
                return this.controller.orderCocktail(tableNumber, drinkName, drinkBrand);
            }
            case ORDER_DELICACY: {
                int tableNumber = Integer.parseInt(data[0]);
                String foodName = data[1];
                return this.controller.orderDelicacy(tableNumber, foodName);
            }
            case LEAVE_BOOTH: {
                int tableNumber = Integer.parseInt(data[0]);
                return this.controller.leaveBooth(tableNumber);
            }
            case GET_INCOME:
                return this.controller.getIncome();
            case END:
                return Command.END.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COMMAND_TYPE, tokens[0]));
        }

    }

}
