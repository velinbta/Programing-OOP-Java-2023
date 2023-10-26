package numberInRange_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int lowerBound = range[0];
        int upperBound = range[1];

        System.out.printf("Range: [%d...%d]\n", lowerBound, upperBound);

        String input = scanner.nextLine();

        while (true) {

            int next;

            try {
                // Can parse and in range
                next = Integer.parseInt(input);

                if (isValid(next, lowerBound, upperBound)) {
                    System.out.printf("Valid number: %d\n", next);
                    break;
                }

            } catch (NumberFormatException ignored) {
            }

            System.out.printf("Invalid number: %s\n", input);
            input = scanner.nextLine();
        }

    }

    private static boolean isValid(int currentNum, int lowerBound, int upperBound) {
        return currentNum >= lowerBound && currentNum <= upperBound;
    }

}
