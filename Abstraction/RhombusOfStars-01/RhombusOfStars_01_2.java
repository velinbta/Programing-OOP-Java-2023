package Abstraction;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RhombusOfStars_01_2 {
    public static void main(String[] args) {

        int rhombusSize = Integer.parseInt(new Scanner(System.in).nextLine());

        String rhombus = getRhombus(rhombusSize);

        System.out.println(rhombus);

    }

    private static String getRhombus(int size) {

        StringBuilder rhombus = new StringBuilder();

        IntStream.rangeClosed(1, size).forEach(row -> {
            // Горна част и център
            int initialRowSpace = size - row;

            String currentRow = getRow(initialRowSpace, row);

            rhombus.append(currentRow);
            rhombus.append(System.lineSeparator());

        });

        IntStream.rangeClosed(1, size - 1).boxed().sorted(Comparator.reverseOrder()).forEach(row -> {
            // Долна част
            int initialRowSpace = size - row;

            String currentRow = getRow(initialRowSpace, row);

            rhombus.append(currentRow);

            if (row != 1) {
                rhombus.append(System.lineSeparator());
            }

        });

        return rhombus.toString();
    }

    private static String getRow(int initialRowSpace, int currentRow) {
        // Текущ ред
        return String.format("%s%s", " ".repeat(initialRowSpace), "* ".repeat(currentRow).trim());

    }

}
