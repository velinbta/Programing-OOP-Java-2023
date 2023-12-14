package onlineShop.core;

import onlineShop.common.Command;
import onlineShop.common.ExceptionMessage;
import onlineShop.io.ConsoleReader;
import onlineShop.io.ConsoleWriter;
import onlineShop.io.InputReader;
import onlineShop.io.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Controller controller;

    public Engine() {
        this.controller = new ControllerImpl();
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
    }

    @Override
    public void run() {

        while (true) {

            String result;

            try {

                result = processInput();

                if (result.equals(Command.CLOSE.name())) {
                    break;
                }

            } catch (IOException | IllegalArgumentException e) {
                result = e.getMessage();
            }

            this.writer.writeLine(result);
        }

    }

    private String processInput() throws IOException {

        String input = this.reader.readLine();
        String[] data = input.split("\\s");

        String commandAsString = data[0];
        Command command = Command.parseCommand(commandAsString);

        switch (command) {
            case ADD_COMPUTER: {
                String computerType = data[1];
                int id = Integer.parseInt(data[2]);
                String manufacturer = data[3];
                String model = data[4];
                double price = Double.parseDouble(data[5]);
                return this.controller.addComputer(computerType, id, manufacturer, model, price);
            }
            case ADD_PERIPHERAL: {
                int computerId = Integer.parseInt(data[1]);
                int id = Integer.parseInt(data[2]);
                String peripheralType = data[3];
                String manufacturer = data[4];
                String model = data[5];
                double price = Double.parseDouble(data[6]);
                double overallPerformance = Double.parseDouble(data[7]);
                String connectionType = data[8];
                return this.controller.addPeripheral(computerId, id, peripheralType, manufacturer,
                        model, price, overallPerformance, connectionType);
            }
            case REMOVE_PERIPHERAL: {
                String peripheralType = data[1];
                int computerId = Integer.parseInt(data[2]);
                return this.controller.removePeripheral(peripheralType, computerId);
            }
            case ADD_COMPONENT: {
                int computerId = Integer.parseInt(data[1]);
                int id = Integer.parseInt(data[2]);
                String componentType = data[3];
                String manufacturer = data[4];
                String model = data[5];
                double price = Double.parseDouble(data[6]);
                double overallPerformance = Double.parseDouble(data[7]);
                int generation = Integer.parseInt(data[8]);
                return this.controller.addComponent(computerId, id, componentType, manufacturer, model,
                        price, overallPerformance, generation);
            }
            case REMOVE_COMPONENT: {
                String componentType = data[1];
                int computerId = Integer.parseInt(data[2]);
                return this.controller.removeComponent(componentType, computerId);
            }
            case BUY_COMPUTER: {
                int id = Integer.parseInt(data[1]);
                return this.controller.buyComputer(id);
            }
            case BUY_BEST_COMPUTER: {
                double budget = Double.parseDouble(data[1]);
                return this.controller.BuyBestComputer(budget);
            }
            case GET_COMPUTER_DATA: {
                int id = Integer.parseInt(data[1]);
                return controller.getComputerData(id);
            }
            case CLOSE:
                return Command.CLOSE.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
