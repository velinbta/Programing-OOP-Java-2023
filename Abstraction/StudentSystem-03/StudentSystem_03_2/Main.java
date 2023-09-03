package StudentSystem_03_2;

import java.util.Scanner;

// Рефакториране на класовете по условие
public class Main {
    private static final String exit = "Exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String input = scanner.nextLine();

        while (!input.equals(exit)) {

            String[] data = input.split("\\s+");

            studentSystem.processStudentData(data);

            input = scanner.nextLine();

        }

    }

}
