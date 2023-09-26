package BirthdayCelebrations_03_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static final String END_COMMAND = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Birthable> birthableCollection = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND)) {

            String[] data = input.split("\\s+");

            Optional<Birthable> birthable = getBirthable(data);
            birthable.ifPresent(birthableCollection::add); // <- no robots

            input = scanner.nextLine();

        }

        String yearDesired = scanner.nextLine();

        birthableCollection.stream().filter(b -> b.getBirthDate().endsWith(yearDesired))
                .forEach(b -> System.out.println(b.getBirthDate()));

    }

    private static Optional<Birthable> getBirthable(String[] data) {
        // Returns Optional<Birthable> from data[]
        Type type = Type.parseType(data[0]); // <- String to Type

        switch (type) {

            case CITIZEN:
                return Optional.of(Citizen.parseCitizen(data));
            case PET:
                return Optional.of(Pet.parsePet(data));
            case ROBOT:
                return Optional.empty(); // <- No robot needed

        }

        // Unreachable exception because of parseType, but required for return
        throw Type.typeException(type.name());
    }

}
