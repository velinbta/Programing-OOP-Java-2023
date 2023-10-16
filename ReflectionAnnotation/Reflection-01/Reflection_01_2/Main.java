package Reflection_01_2;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = tryGetClass();

        if (Objects.isNull(clazz)) {
            return;
        }

        System.out.println("class " + clazz.getSimpleName()); // <- class type
        System.out.println(clazz.getSuperclass()); // <- super class type

        Class<?>[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println); // <- all interfaces

        Reflection reflection = tryGetNewInstance(clazz);
        System.out.println(reflection); // <- to String of the reflected class Reflection

    }

    @SuppressWarnings({"unchecked"})
    private static Class<Reflection> tryGetClass() {
        // if have no access to the class
        String className = "Reflection_01_2.Reflection";

        Class<Reflection> clazz = null;

        try {
            clazz = (Class<Reflection>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find " + className);
        }

        return clazz;
    }

    private static Reflection tryGetNewInstance(Class<Reflection> clazz) {
        // new instance using reflection
        Reflection reflection = null;

        try {
            reflection = clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                | InvocationTargetException e) {
            System.out.println("Cannot instantiate new instance");
        }

        return reflection;
    }

}
