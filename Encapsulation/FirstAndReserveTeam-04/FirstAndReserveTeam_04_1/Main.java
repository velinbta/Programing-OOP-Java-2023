package FirstAndReserveTeam_04_1;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Team team = new Team("Black Eagles");

        IntStream.range(0, lines).mapToObj(line -> scanner.nextLine().split("\\s+")).forEach(data -> {

            Optional<Person> person = Optional.empty();

            try {

                person = Person.parsePerson(data); // <- new Optional<Person> from data[]

            } catch (IllegalStateException e) {

                System.out.println(e.getMessage());

            }

            person.ifPresent(team::addPlayer);

        });

        System.out.println(team);

    }

}
