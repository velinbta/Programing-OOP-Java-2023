package BorderControl_05_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static final String END_COMMAND = "End";
    public static final int IS_ROBOT = 2;
    public static final int IS_CITIZEN = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Identifiable> identifiableCollection = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND)) {

            String[] data = input.split("\\s+");

            Identifiable identifiable = getIdentifiable(data); // <- parse

            identifiableCollection.add(identifiable);

            input = scanner.nextLine();
        }

        String fakeIdEndingLiteral = scanner.nextLine();

        identifiableCollection.stream().filter(i -> i.getId().endsWith(fakeIdEndingLiteral))
                .forEach(i -> System.out.println(i.getId())); // <- detained

    }

    private static Identifiable getIdentifiable(String[] data) {
        // Returns Identifiable, arguments length based
        switch (data.length) {

            // Parse
            case IS_ROBOT:

                return Robot.parseRobot(data);

            case IS_CITIZEN:

                return Citizen.parseCitizen(data);

            default:
                throw new IllegalArgumentException("Invalid number of arguments " + data.length);

        }

    }

}
