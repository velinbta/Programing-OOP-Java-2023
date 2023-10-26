package numberInRange_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class NumberOutOfRangeException extends RuntimeException {
        NumberOutOfRangeException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = readArray(scanner);

        int lowerBound = range[0];
        int upperBound = range[1];

        System.out.printf("Range: [%d...%d]\n", lowerBound, upperBound);

        String input = scanner.nextLine();

        while (true) {

            try {

                int next = Integer.parseInt(input);

                if (!isInRange(next, lowerBound, upperBound)) {
                    throw new NumberOutOfRangeException(String.format("%d is out of range [%d...%d]\n",
                            next, lowerBound, upperBound));
                }

                printTextPlusNumber("Valid", String.valueOf(next));

                break;
            } catch (NumberFormatException | NumberOutOfRangeException e) {
                printTextPlusNumber("Invalid", input);
            }

            input = scanner.nextLine();
        }

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isInRange(int currentNum, int lowerBound, int upperBound) {
        return currentNum >= lowerBound && currentNum <= upperBound;
    }

    private static void printTextPlusNumber(String text, String numberAsString) {
        System.out.printf("%s number: %s\n", text, numberAsString);
    }

}
