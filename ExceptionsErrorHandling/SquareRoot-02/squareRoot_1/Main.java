package squareRoot_1;

import java.util.Scanner;

public class Main {

    public static class NegativeNumberException extends IllegalArgumentException {
        public NegativeNumberException() {
            super();
        }

        public NegativeNumberException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        String numberAsString = new Scanner(System.in).nextLine();

        try {

            int number = Integer.parseInt(numberAsString);

            if (number < 0) {
                throw new NegativeNumberException("Invalid");
            }

            double sqrt = Math.sqrt(number);

            System.out.printf("%.2f\n", sqrt);

        } catch (IllegalArgumentException e) {
            // catch both NumberFormatException and NegativeNumberException
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }

}
