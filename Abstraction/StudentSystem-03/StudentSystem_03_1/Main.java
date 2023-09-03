package StudentSystem_03_1;

import java.util.Scanner;

// Не е рефакториран, както по условие - написан е наново
public class Main {

    public static final String exit = "Exit";
    public static final String create = "Create";
    public static final String show = "Show";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals(exit)) {

            String[] data = input.split("\\s+");
            String command = data[0];
            String name = data[1];

            switch (command) {

                case create: // <- Създава, добавя

                    int age = Integer.parseInt(data[2]);
                    double grade = Double.parseDouble(data[3]);

                    Student student = new Student(name, age, grade);

                    StudentSystem.add(student);

                    break;

                case show: // <- Принтира

                    StudentSystem.printStudentInfo(name);

                    break;

            }

            input = scanner.nextLine();
        }

    }

}
