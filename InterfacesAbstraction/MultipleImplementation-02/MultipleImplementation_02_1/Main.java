package MultipleImplementation_02_1;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Refactored
        List<Class<?>> citizenInterfaces = Arrays.asList(Citizen.class.getInterfaces());

        boolean containInterfaces = citizenInterfaces.contains(Birthable.class)
                && citizenInterfaces.contains(Identifiable.class);

        if (!containInterfaces) {
            return;
        }

        Method[] birthableMethods = Birthable.class.getDeclaredMethods();
        Method[] identifiableMethods = Identifiable.class.getDeclaredMethods();

        // <- Ignored
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String id = scanner.nextLine();
        String birthDate = scanner.nextLine();

        Identifiable identifiable = new Citizen(name, age, id, birthDate);
        Birthable birthable = new Citizen(name, age, id, birthDate);
        // -> Ignored

        System.out.println(birthableMethods.length);
        System.out.println(birthableMethods[0].getReturnType().getSimpleName());
        System.out.println(identifiableMethods.length);
        System.out.println(identifiableMethods[0].getReturnType().getSimpleName());

    }

}
