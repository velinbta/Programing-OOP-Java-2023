package SalaryIncrease_02_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] data = reader.readLine().split("\\s+");
            Person person = Person.parsePerson(data);

            people.add(person);
        }

        double percent = Double.parseDouble(reader.readLine());
        people.forEach(p -> p.increaseSalary(percent)); // <- increase (if age < 30, bonus / 2)

        people.forEach(System.out::println);

    }

}
