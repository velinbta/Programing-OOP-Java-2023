package enterNumbers_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static class NumberOutOfRangeException extends IllegalArgumentException {

        public NumberOutOfRangeException() {
            super();
        }

        public NumberOutOfRangeException(String message) {
            super(message);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] integerArr = new int[10];
        int arrayIndex = 0;

        int lowerBound = 1;

        while (arrayIndex < 10) { // <- needs to add 10 numbers

            String numberAsString = scanner.nextLine();

            try {
                int number = Integer.parseInt(numberAsString);

                // lowerBound change which can lead to never ending program
                boolean isInRange = number > lowerBound && number < 100;

                if (!isInRange) {
                    throw new NumberOutOfRangeException();
                }

                integerArr[arrayIndex++] = number;
                lowerBound = number;

            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (NumberOutOfRangeException e) {
                System.out.printf("Your number is not in range %d - 100!\n", lowerBound);
            }

        }

        System.out.println(Arrays.stream(integerArr).mapToObj(String::valueOf).
                collect(Collectors.joining(", ")));

    }

}
