package SortByNameAndAge_01_1;

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
            Person person = Person.parse(data); // <- Нов Person

            people.add(person);
        }

        people.sort(new FirstNameAgeAscendingComparator());

        people.forEach(System.out::println);

    }

}
