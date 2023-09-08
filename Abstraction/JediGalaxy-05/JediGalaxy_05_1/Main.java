package JediGalaxy_05_1;

import java.util.Arrays;
import java.util.Scanner;

// Задачата е решена (не е рефакторирана от друг код, като по условие)
public class Main {

    public static final String COMMAND = "Let the Force be with you";
    public static long totalStars = 0L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = parseIntArray(scanner.nextLine());

        // Нарастващи стойности започващи от 0
        int[][] matrix = MatrixUtil.createInitialValueMatrix(dimensions[0], dimensions[1]);

        String input = scanner.nextLine();

        while (!input.equals(COMMAND)) {

            // Стартовите позиции на двамата
            int[] playerPosition = parseIntArray(input);
            int[] evilPosition = parseIntArray(scanner.nextLine());

            MatrixUtil.destroyStars(matrix, evilPosition[0], evilPosition[1]);

            long collectedStars = MatrixUtil.collectStars(matrix, playerPosition[0], playerPosition[1]);

            totalStars += collectedStars;

            input = scanner.nextLine();

        }

        System.out.println(totalStars);

    }

    private static int[] parseIntArray(String input) {
        // Парсва масив
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

}
