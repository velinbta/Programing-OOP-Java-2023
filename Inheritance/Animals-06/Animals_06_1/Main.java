package Animals_06_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "Beast!";
    private static final String DOG_COMMAND = "Dog";
    private static final String FROG_COMMAND = "Frog";
    private static final String CAT_COMMAND = "Cat";
    private static final String KITTEN_COMMAND = "Kitten";
    private static final String TOMCAT_COMMAND = "Tomcat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>(); // <- Polymorphism

        while (!input.equals(END_COMMAND)) {

            String type = input;
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];

            Optional<Animal> animal = createAnimalOrCatchException(type, name, age, gender);
            animal.ifPresent(animals::add); // <- add if not empty

            input = scanner.nextLine();

        }

        animals.forEach(System.out::println);

    }

    private static Optional<Animal> createAnimalOrCatchException(String type, String name, int age, String gender) {
        // Creates Optional<Animal> or catches Illegal data
        try {

            switch (type) {

                case DOG_COMMAND:
                    return Optional.of(new Dog(name, age, gender));
                case FROG_COMMAND:
                    return Optional.of(new Frog(name, age, gender));
                case CAT_COMMAND:
                    return Optional.of(new Cat(name, age, gender));
                case KITTEN_COMMAND:
                    return Optional.of(new Kitten(name, age));
                case TOMCAT_COMMAND:
                    return Optional.of(new Tomcat(name, age));

                default:
                    throw new IllegalArgumentException("Invalid input!");
            }

        } catch (IllegalStateException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        return Optional.empty();
    }

}
