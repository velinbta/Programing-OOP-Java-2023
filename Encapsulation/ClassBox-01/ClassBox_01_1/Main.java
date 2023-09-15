package ClassBox_01_1;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Optional<Box> box = tryCreateBox(length, width, height);
        box.ifPresent(System.out::println);

    }

    private static Optional<Box> tryCreateBox(double length, double width, double height) {

        Optional<Box> box = Optional.empty();

        try {

            box = Optional.of(new Box(length, width, height));

        } catch (IllegalStateException e) {

            System.out.println(e.getMessage());

        }

        return box;
    }

}
