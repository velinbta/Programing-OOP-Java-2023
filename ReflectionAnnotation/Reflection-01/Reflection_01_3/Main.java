package Reflection_01_3;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        System.out.println("class " + clazz.getSimpleName()); // <- type
        System.out.println(clazz.getSuperclass());
        Arrays.stream(clazz.getInterfaces()).forEach(System.out::println);

        Reflection newInstance = tryGetNewInstance(clazz);
        System.out.println(newInstance);

    }

    private static Reflection tryGetNewInstance(Class<Reflection> clazz) {
        // instantiate an object of Reflection or throw
        try {
            return clazz.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }

    }

}
