package hero;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

        // Optional info, because no task is presented
        Class<?> clazz = MuseElf.class;
        System.out.println(getHierarchy(clazz, true));

        clazz = SoulMaster.class;
        System.out.println(getHierarchy(clazz, true));

        clazz = BladeKnight.class;
        System.out.println(getHierarchy(clazz, false));

    }

    private static String getHierarchy(Class<?> clazz, boolean addDelimiter) {
        // returns given class hierarchy as a String
        StringBuilder hierarchy = new StringBuilder();

        Deque<String> ordered = new ArrayDeque<>();

        while (!clazz.getSimpleName().equals("Object")) {
            ordered.push(String.format("%s is derived from %s", clazz.getSimpleName(),
                    clazz.getSuperclass().getSimpleName()));
            clazz = clazz.getSuperclass();
        }

        while (!ordered.isEmpty()) {
            hierarchy.append(ordered.pop());
            hierarchy.append(System.lineSeparator());
        }

        if (addDelimiter) {
            hierarchy.append("-----------------------------");
        }

        return hierarchy.toString().trim();
    }

}
