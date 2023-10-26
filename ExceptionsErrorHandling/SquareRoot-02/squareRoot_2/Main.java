package squareRoot_2;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static class NegativeNumberException extends IllegalArgumentException {

        public NegativeNumberException(String message) {
            super(message);
        }

    }

    public static void main(String[] args) {

        String numberAsString = new Scanner(System.in).nextLine();

        Integer number = tryGetPositiveIntegerNumberOrElseNull(numberAsString);

        String sqrtOutput = Objects.isNull(number)
                ? "Invalid"
                : String.format("%.2f", Math.sqrt(number));

        System.out.println(sqrtOutput);
        System.out.println("Goodbye");

    }

    private static Integer tryGetPositiveIntegerNumberOrElseNull(String numberAsString) {
        // parse positive Integer or null
        Integer number;

        try {
            number = Integer.parseInt(numberAsString);

            if (number < 0) {
                throw new NegativeNumberException("Non negative number required!");
            }

        } catch (IllegalArgumentException e) {
            number = null;
        }

        return number;
    }

}
