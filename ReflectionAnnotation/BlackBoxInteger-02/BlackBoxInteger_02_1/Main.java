package BlackBoxInteger_02_1;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {

    public static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        int startValue = tryGetDefaultStartValue(clazz);

        BlackBoxInt blackBoxIntInstance = tryGetNewInstance(clazz, startValue);

        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND)) {

            String[] data = input.split("_");
            String command = data[0];
            int value = Integer.parseInt(data[1]);

            Method currentMethod = tryGetMethodByCommand(clazz, command);
            currentMethod.setAccessible(true);

            try {
                // invokes the method on instance of the class
                currentMethod.invoke(blackBoxIntInstance, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("Cannot invoke method");
            }

            // if not declared here doesn't update when methods invoke
            int innerValue = tryGetValueFromField(clazz, blackBoxIntInstance);
            System.out.println(innerValue);

            input = scanner.nextLine();

        }

    }

    private static int tryGetDefaultStartValue(Class<BlackBoxInt> clazz) {
        // gets the initial value of static field
        int defaultStartValue = -1;

        String fieldName = "DEFAULT_VALUE";

        try {
            Field fieldDefaultValue = clazz.getDeclaredField(fieldName);
            fieldDefaultValue.setAccessible(true);

            defaultStartValue = fieldDefaultValue.getInt(null);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Cannot access field " + fieldName);
        }

        return defaultStartValue;
    }

    private static BlackBoxInt tryGetNewInstance(Class<BlackBoxInt> clazz, int initialStartValue) {
        // gets a new instance of BlackBoxInt class
        BlackBoxInt blackBoxInt = null;

        try {

            Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor(int.class);
            declaredConstructor.setAccessible(true);

            blackBoxInt = declaredConstructor.newInstance(initialStartValue);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                | InvocationTargetException e) {
            System.out.println("Cannot instantiate new instance of class " + clazz.getSimpleName());
        }

        return blackBoxInt;
    }

    private static Method tryGetMethodByCommand(Class<BlackBoxInt> clazz, String command) {
        // gets method in Class<BlackBoxInt> depending on the command
        Method method = null;

        try {
            method = clazz.getDeclaredMethod(command, int.class);
        } catch (NoSuchMethodException e) {
            System.out.println("Cannot get method " + command);
        }

        return method;
    }

    private static int tryGetValueFromField(Class<BlackBoxInt> clazz, BlackBoxInt blackBoxIntInstance) {
        // gets value from field on an instance
        String fieldName = "innerValue";
        int innerValue = 0;

        try {
            Field innerValueField = clazz.getDeclaredField(fieldName);
            innerValueField.setAccessible(true);

            innerValue = innerValueField.getInt(blackBoxIntInstance);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Cannot get value from field " + fieldName);
        }

        return innerValue;
    }

}
