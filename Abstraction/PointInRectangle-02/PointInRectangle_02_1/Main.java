package PointInRectangle_02_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectanglePoints = readArray(scanner);

        Point bottom = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point top = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rectangle = new Rectangle(bottom, top);

        int lines = Integer.parseInt(scanner.nextLine());

        while (lines-- > 0) {

            // Прочита и проверява, дали дадената точка се съдържа в координатите на правоъгълника
            int[] points = readArray(scanner);
            Point currentPoint = new Point(points[0], points[1]);

            System.out.println(rectangle.contains(currentPoint));

        }

    }

    private static int[] readArray(Scanner scanner) {
        // Причита масив
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
    }

}
