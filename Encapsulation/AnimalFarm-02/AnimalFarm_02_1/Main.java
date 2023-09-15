package AnimalFarm_02_1;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Optional<Chicken> chicken = tryCreateChicken(name, age);
        chicken.ifPresent(System.out::println);

    }

    private static Optional<Chicken> tryCreateChicken(String name, int age) {

        Optional<Chicken> chicken = Optional.empty();

        try {

            chicken = Optional.of(new Chicken(name, age));

        } catch (IllegalStateException e) { // <- if illegal

            System.out.println(e.getMessage());

        }

        return chicken;
    }

}
