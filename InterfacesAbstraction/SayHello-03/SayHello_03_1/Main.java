package SayHello_03_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Refactored sample code given
        List<Person> people = new ArrayList<>(List.of(new Bulgarian("Peter"),
                new European("John"), new Chinese("Lee")));

        people.forEach(person -> System.out.println(person.sayHello()));

    }

}
