package JediGalaxy_05_1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MatrixUtil {

    private MatrixUtil() {
        // Don't let anyone instantiate an instance of this class
    }

    public static int[][] createInitialValueMatrix(int rows, int cols) {
        // Нарастващ пореден int, започва от 0
        int[][] matrix = new int[rows][cols];

        AtomicInteger value = new AtomicInteger();

        IntStream.range(0, matrix.length).forEach(row -> IntStream.range(0, matrix[row].length).
                forEach(col -> matrix[row][col] = value.getAndIncrement()));

        return matrix;
    }

    public static void destroyStars(int[][] matrix, int startRow, int startCol) {

        int row = startRow;
        int col = startCol;

        boolean isOutside = !isInBounds(matrix, row, col);

        while (isOutside) {

            isOutside = !isInBounds(matrix, --row, --col); // <- Опитва да влезе

            if (row <= 0 || col <= 0) { // <- Стига гранични стойности на матрицата
                break;
            }

        }

        boolean isInside = isInBounds(matrix, row, col);

        while (isInside) { // <- Унищожава "звездите" в матрицата

            matrix[row][col] = 0;

            isInside = isInBounds(matrix, --row, --col);

        }

    }

    public static long collectStars(int[][] matrix, int startRow, int startCol) {

        int row = startRow;
        int col = startCol;

        boolean isOutside = !isInBounds(matrix, row, col);

        while (isOutside && row > 0) { // <- Извън матрицата, без да е достигнал гранична стойност на ред

            isOutside = !isInBounds(matrix, --row, ++col); // <- Опитва да влезе

        }

        boolean isInside = isInBounds(matrix, row, col);

        long stars = 0L;

        while (isInside) { // <- Събира "звезди"

            stars += matrix[row][col];

            isInside = isInBounds(matrix, --row, ++col);

        }

        return stars;
    }

    public static boolean isInBounds(int[][] matrix, int row, int col) {
        // Границите на матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

}
