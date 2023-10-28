package numberInRange_4;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = readArray(scanner);

        int lowerBound = range[0];
        int upperBound = range[1];

        System.out.printf("Range: [%d...%d]\n", lowerBound, upperBound);

        String numberAsString = scanner.nextLine();

        Integer number;
        do {
            // non null and in range
            number = tryParseIntegerInRangeOrElseNull(numberAsString, lowerBound, upperBound);

            if (Objects.isNull(number)) {
                System.out.printf("Invalid number: %s\n", numberAsString);
                numberAsString = scanner.nextLine();
            }

        } while (Objects.isNull(number));

        System.out.printf("Valid number: %d\n", number);

    }

    private static Integer tryParseIntegerInRangeOrElseNull(String numberAsString, int lowerBound, int upperBound) {

        try {

            int number = Integer.parseInt(numberAsString);

            if (!isInRangeInclusive(lowerBound, upperBound, number)) {
                return null;
            }

            return number;
        } catch (NumberFormatException e) {
            return null;
        }

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isInRangeInclusive(int lowerBound, int upperBound, int number) {
        return number >= lowerBound && number <= upperBound;
    }

}
