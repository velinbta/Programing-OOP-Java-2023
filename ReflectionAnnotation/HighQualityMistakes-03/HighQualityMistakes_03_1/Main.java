package HighQualityMistakes_03_1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Set<Field> fields = getFieldsOrderedByName(clazz);
        Set<Method> getters = getMethodsFilteredByConditionOrderedByName(clazz, m -> m.getName().startsWith("get"));
        Set<Method> setters = getMethodsFilteredByConditionOrderedByName(clazz, m -> m.getName().startsWith("set"));

        // decoded by class Modifier and printed
        fields.forEach(field -> {
            int modifiers = field.getModifiers();

            if (!Modifier.isPrivate(modifiers))
                System.out.printf("%s must be private!\n", field.getName());
        });

        getters.forEach(getter -> {
            int modifiers = getter.getModifiers();

            if (!Modifier.isPublic(modifiers))
                System.out.printf("%s have to be public!\n", getter.getName());
        });

        setters.forEach(setter -> {
            int modifiers = setter.getModifiers();

            if (!Modifier.isPrivate(modifiers))
                System.out.printf("%s have to be private!\n", setter.getName());
        });

    }

    private static Set<Field> getFieldsOrderedByName(Class<Reflection> clazz) {
        // creates new Set<Field> ordered by name
        Set<Field> fields = new TreeSet<>(new MemberNameComparator());

        // adds all fields
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        return fields;
    }

    private static Set<Method> getMethodsFilteredByConditionOrderedByName(Class<Reflection> clazz,
                                                                          Predicate<Method> condition) {
        // creates new Set<Method> ordered by name
        Set<Method> methods = new TreeSet<>(new MemberNameComparator());

        // adds filtered by condition methods
        Arrays.stream(clazz.getDeclaredMethods()).filter(condition).forEach(methods::add);

        return methods;
    }

}
