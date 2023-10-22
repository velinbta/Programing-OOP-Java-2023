package GettersAndSetters_02_1;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    private static final String GETTERS_FORMAT = "%s will return class %s";
    private static final String SETTERS_FORMAT = "%s and will set field of class %s";

    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Comparator<Member> nameComparator = Comparator.comparing(Member::getName);

        Set<Method> getters = new TreeSet<>(nameComparator);
        Set<Method> setters = new TreeSet<>(nameComparator);

        for (Method method : clazz.getDeclaredMethods()) {
            if (isGetter(method)) getters.add(method);
            else if (isSetter(method)) setters.add(method);
        }

        getters.forEach(m -> System.out.printf(GETTERS_FORMAT, m.getName(),
                m.getReturnType().getName() + System.lineSeparator()));

        setters.forEach(m -> System.out.printf(SETTERS_FORMAT, m.getName(),
                m.getParameterTypes()[0].getName() + System.lineSeparator()));

    }

    private static boolean isGetter(Method method) {
        // starts with get, has 0 parameters and doesn't return void
        return method.getName().startsWith("get") && method.getParameterCount() == 0
                && !method.getReturnType().equals(void.class);
    }

    private static boolean isSetter(Method method) {
        // starts with set has 1 parameter and returns void
        return method.getName().startsWith("set") && method.getParameterCount() == 1
                && method.getReturnType().equals(void.class);
    }

}
