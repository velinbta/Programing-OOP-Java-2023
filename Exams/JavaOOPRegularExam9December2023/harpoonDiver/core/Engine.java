package harpoonDiver.core;

import harpoonDiver.common.Command;
import harpoonDiver.common.ExceptionMessage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Engine implements Runnable {

    private final Controller controller;
    private final Scanner scanner;

    public Engine(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
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

        String input = this.scanner.nextLine();
        String[] data = input.split("\\s+");

        String commandAsString = data[0];
        Command command = Command.parseCommand(commandAsString);

        switch (command) {
            case ADD_DIVER: {
                String kind = data[1];
                String diverName = data[2];
                return this.controller.addDiver(kind, diverName);
            }
            case ADD_DIVING_SITE: {
                String siteName = data[1];
                String[] seaCreatures = Arrays.stream(data).skip(2).toArray(String[]::new);
                return this.controller.addDivingSite(siteName, seaCreatures);
            }
            case REMOVE_DIVER: {
                String diverName = data[1];
                return this.controller.removeDiver(diverName);
            }
            case START_DIVING: {
                String siteName = data[1];
                return this.controller.startDiving(siteName);
            }
            case GET_STATISTICS:
                return this.controller.getStatistics();
            case EXIT:
                return Command.EXIT.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
