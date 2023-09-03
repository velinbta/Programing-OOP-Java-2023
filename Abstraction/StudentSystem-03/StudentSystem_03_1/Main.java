package StudentSystem_03_1;

import java.util.Scanner;

// Не е рефакториран, както по условие - написан е наново
public class Main {

    public static final String EXIT_COMMAND = "Exit";
    public static final String CREATE_COMMAND = "Create";
    public static final String SHOW_COMMAND = "Show";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals(EXIT_COMMAND)) {

            String[] data = input.split("\\s+");
            String command = data[0];
            String name = data[1];

            switch (command) {

                case CREATE_COMMAND:

                    // Създава, добавя
                    int age = Integer.parseInt(data[2]);
                    double grade = Double.parseDouble(data[3]);

                    Student student = new Student(name, age, grade);

                    StudentSystem.add(student);

                    break;

                case SHOW_COMMAND:

                    // Принтира
                    StudentSystem.printStudentInfo(name);

                    break;

            }

            input = scanner.nextLine();
        }

    }

}
