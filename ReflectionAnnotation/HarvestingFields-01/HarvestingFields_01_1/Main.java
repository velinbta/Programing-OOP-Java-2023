package HarvestingFields_01_1;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static final String END_COMMAND = "HARVEST";
    public static final String PRIVATE_COMMAND = "private";
    public static final String PROTECTED_COMMAND = "protected";
    public static final String PUBLIC_COMMAND = "public";
    public static final String ALL_COMMAND = "all";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;

        Field[] allFields = clazz.getDeclaredFields();

        String command = scanner.nextLine();

        while (!command.equals(END_COMMAND)) {

            switch (command) {
                // filtered conditions
                case PRIVATE_COMMAND:

                    printFields(allFields, field -> Modifier.isPrivate(field.getModifiers()));

                    break;

                case PROTECTED_COMMAND:

                    printFields(allFields, field -> Modifier.isProtected(field.getModifiers()));

                    break;

                case PUBLIC_COMMAND:

                    printFields(allFields, field -> Modifier.isPublic(field.getModifiers()));

                    break;

                case ALL_COMMAND:

                    printFields(allFields);

                    break;

                default:
                    throw new IllegalArgumentException("Unknown command " + command);
            }

            command = scanner.nextLine();
        }

    }

    public static void printFields(Field[] fields, Predicate<Member> condition) {
        // field and a condition to be filtered
        getFieldsStream(fields).filter(condition).forEach(getFieldConsumer());
    }

    private static void printFields(Field[] fields) {
        // all fields
        getFieldsStream(fields).forEach(getFieldConsumer());
    }

    private static Stream<Field> getFieldsStream(Field[] fields) {
        return Arrays.stream(fields);
    }

    private static Consumer<Field> getFieldConsumer() {
        return field -> System.out.println(getFieldPrintFormat(field));
    }

    private static String getFieldPrintFormat(Field field) {
        // print format
        return String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(),
                field.getName());
    }

}
