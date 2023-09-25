package DefineAnInterfacePerson_01_1;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample code reformatted
        Class<?>[] citizenInterfaces = Citizen.class.getInterfaces();

        boolean personExists = Arrays.asList(citizenInterfaces).contains(Person.class);

        if (!personExists) {
            return;
        }

        Method[] methodsInPerson = Person.class.getDeclaredMethods();

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Person person = new Citizen(name, age);

        System.out.println(methodsInPerson.length);
        System.out.println(person.getName());
        System.out.println(person.getAge());

    }

}


