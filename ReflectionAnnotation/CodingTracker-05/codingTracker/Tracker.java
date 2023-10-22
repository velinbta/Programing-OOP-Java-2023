package codingTracker;

import java.lang.reflect.Method;
import java.util.Objects;

public class Tracker {

    private Tracker() {
        // Util
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> clazz) {

        Method[] allMethods = clazz.getDeclaredMethods();

        for (Method method : allMethods) {
            Author annotation = method.getAnnotation(Author.class);

            String track = Objects.nonNull(annotation)
                    ? String.format("%s: %s()", annotation.name(), method.getName())
                    : String.format("Author unavailable: %s()", method.getName());

            System.out.println(track);
        }

    }

}
