package barracksWars.core;

import barracksWars.core.commands.BaseCommand;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMANDS_PACKAGE_NAME = "barracksWars.core.commands.";
    private static final String END_COMMAND = "fight";

    private final Repository repository;
    private final UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            try {

                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);

                if (result.equals(END_COMMAND)) {
                    break;
                }

                System.out.println(result);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private String interpretCommand(String[] data, String commandName) {

        // package based reflection
        String refactoredCommand = Character.toUpperCase(commandName.charAt(0)) +
                commandName.substring(1) + "Command";

        try {
            // public no args ctor expected
            Constructor<?> ctor = Class.forName(COMMANDS_PACKAGE_NAME.concat(refactoredCommand)).
                    getConstructor(String[].class, Repository.class, UnitFactory.class);

            BaseCommand command = (BaseCommand) ctor.newInstance(data, this.repository, this.unitFactory);

            return command.execute();

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }

    }

}
