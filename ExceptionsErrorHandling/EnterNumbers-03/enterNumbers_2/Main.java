package enterNumbers_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Integer> integers = new ArrayList<>();

        AtomicInteger lowerBound = new AtomicInteger(1);

        while (integers.size() < 10) { // <- 10 numbers needed

            String numberAsString = scanner.nextLine();

            Optional<Integer> optionalNumber = tryParseInteger(numberAsString);

            // lowerBound change which can lead to program never ending (96 - 97 - 98 - 99 - ???)
            optionalNumber.ifPresentOrElse(number -> {
                if (isInRangeExclusive(lowerBound.get(), 100, number)) {
                    integers.add(number);
                    lowerBound.set(number);
                } else {
                    System.out.printf("Your number is not in range %d - 100!\n", lowerBound.get());
                }
            }, () -> System.out.println("Invalid Number!"));

        }

        System.out.println(integers.stream().map(String::valueOf).
                collect(Collectors.joining(", ")));

    }

    private static Optional<Integer> tryParseInteger(String numberAsString) {
        // or else empty
        Optional<Integer> optionalNumber = Optional.empty();

        try {
            int number = Integer.parseInt(numberAsString);

            optionalNumber = Optional.of(number);

        } catch (NumberFormatException ignored) {

        }

        return optionalNumber;
    }

    private static boolean isInRangeExclusive(int lowerBound, int upperBound, int number) {
        return number > lowerBound && number < upperBound;
    }

}
