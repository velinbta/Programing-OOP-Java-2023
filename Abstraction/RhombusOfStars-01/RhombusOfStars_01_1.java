package Abstraction;

import java.util.Scanner;

public class RhombusOfStars_01_1 {
    public static void main(String[] args) {

        int rhombusSize = Integer.parseInt(new Scanner(System.in).nextLine());

        for (int upper = 1; upper <= rhombusSize; upper++) {
            // Горна част и център
            printRow(rhombusSize, upper);

        }

        for (int down = rhombusSize - 1; down >= 1; down--) {
            // Долна част
            printRow(rhombusSize, down);

        }

    }

    private static void printRow(int rhombusSize, int currentRow) {
        // Форматира и принтира текущия ред
        int initialRowSpaces = rhombusSize - currentRow;

        String rowFormat = String.format("%s%s", " ".repeat(initialRowSpaces), "* ".repeat(currentRow).trim());

        System.out.println(rowFormat);

    }

}
