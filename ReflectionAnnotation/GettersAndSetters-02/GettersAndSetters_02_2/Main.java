package GettersAndSetters_02_2;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        // all methods declared withing the class
        Method[] methods = clazz.getDeclaredMethods();

        // by name alphabetically
        Set<Method> getters = new TreeSet<>(new MethodNameComparator());
        Set<Method> setters = new TreeSet<>(new MethodNameComparator());

        Arrays.stream(methods).forEach(method -> {
            String methodName = method.getName();
            boolean isGetter = methodName.startsWith("get");
            boolean isSetter = methodName.startsWith("set");

            if (isGetter) getters.add(method);
            else if (isSetter) setters.add(method);
        });

        for (Method getter : getters) {
            System.out.printf("%s will return class %s\n", getter.getName(),
                    getter.getReturnType().getName());
        }

        for (Method setter : setters) {
            System.out.printf("%s and will set field of class %s\n", setter.getName(),
                    setter.getParameterTypes()[0].getName());
        }

    }

}
