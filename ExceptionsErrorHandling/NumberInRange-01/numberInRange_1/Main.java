package numberInRange_1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = readArray(scanner);

        int lowerBound = range[0];
        int upperBound = range[1];

        System.out.printf("Range: [%d...%d]\n", lowerBound, upperBound);

        String input = scanner.nextLine();

        while (true) {

            while (!input.matches("^[-+]*\\d+$")) { // <- is not a number
                printTextPlusNumber("Invalid", input);
                input = scanner.nextLine();
            }

            BigInteger next = new BigInteger(input);

            if (isInRange(next, lowerBound, upperBound)) { // <- if in range
                printTextPlusNumber("Valid", String.valueOf(next));
                break;
            }

            printTextPlusNumber("Invalid", String.valueOf(next));
            input = scanner.nextLine();
        }

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isInRange(BigInteger number, int lowerBound, int upperBound) {
        // some tests contain really long digits
        return number.compareTo(BigInteger.valueOf(lowerBound)) >= 0 &&
                number.compareTo(BigInteger.valueOf(upperBound)) <= 0;
    }

    private static void printTextPlusNumber(String text, String numberAsString) {
        System.out.printf("%s number: %s\n", text, numberAsString);
    }

}
