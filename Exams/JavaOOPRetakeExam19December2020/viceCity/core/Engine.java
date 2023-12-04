package viceCity.core;

import viceCity.common.Command;
import viceCity.common.ExceptionMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            case ADD_PLAYER: {
                String name = data[1];
                return this.controller.addPlayer(name);
            }
            case ADD_GUN: {
                String type = data[1];
                String name = data[2];
                return this.controller.addGun(type, name);
            }
            case ADD_GUN_TO_PLAYER: {
                String name = data[1];
                return this.controller.addGunToPlayer(name);
            }
            case FIGHT:
                return this.controller.fight();
            case EXIT:
                return Command.EXIT.name();
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_COMMAND_FORMAT,
                        commandAsString));
        }

    }

}
