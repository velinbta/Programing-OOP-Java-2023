package SayHelloExtend_04_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Refactored sample code
        List<Person> people = new ArrayList<>(List.of(new Bulgarian("Ivan"),
                new European("Tyrone"), new Chinese("Bruce")));

        people.forEach(p -> System.out.println(p.sayHello()));

    }

}
