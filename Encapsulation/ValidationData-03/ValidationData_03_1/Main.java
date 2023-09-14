package ValidationData_03_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < lines; i++) {

            String[] data = scanner.nextLine().split("\\s+");

            Optional<Person> person = Optional.empty();

            try {
                person = Person.parsePerson(data);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            person.ifPresent(people::add); // <- Ако е с валидно състояние

        }

        double percent = Double.parseDouble(scanner.nextLine());

        people.forEach(p -> p.increaseSalary(percent)); // <- increase (if age < 30, bonus / 2)
        people.forEach(System.out::println);

    }

}
