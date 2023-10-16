package Reflection_01_1;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        System.out.println("class " + clazz.getSimpleName()); // <- class type
        System.out.println(clazz.getSuperclass()); // <- super class type

        Class<?>[] interfaces = clazz.getInterfaces(); // <- all interfaces
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection reflectionInstance = tryGetNewInstance(clazz);

        if (reflectionInstance == null) {
            return;
        }

        System.out.println(reflectionInstance); // <- to String of the reflected new instance

    }

    private static Reflection tryGetNewInstance(Class<Reflection> clazz) {
        // new instance using java.lang.reflect
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
