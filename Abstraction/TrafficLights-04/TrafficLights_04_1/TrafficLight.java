package TrafficLights_04_1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Светофар и следващата му стойност
public enum TrafficLight {

    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private final String nextLight;

    TrafficLight(String nextLight) {
        this.nextLight = nextLight;
    }

    public String getNextLight() {
        return nextLight;
    }

    private static TrafficLight[] lights;

    public static void inputStoredLightValues(String... lightValues) {

        // Прочита и добавя в статичната променлива "lights"
        lights = new TrafficLight[lightValues.length];

        IntStream.range(0, lightValues.length).forEach(n ->
                lights[n] = TrafficLight.valueOf(lightValues[n]));

    }

    public static void changeAllLightValuesToNext() {

        // Променя всички стойности на следващите по ред
        IntStream.range(0, lights.length).forEach(n -> {

            TrafficLight current = lights[n];
            lights[n] = TrafficLight.valueOf(current.getNextLight());

        });

    }

    public static void printStoredLights() {

        String values = Arrays.stream(lights).map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(values);

    }

}
