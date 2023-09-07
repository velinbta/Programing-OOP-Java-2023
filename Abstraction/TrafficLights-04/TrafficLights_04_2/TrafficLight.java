package TrafficLights_04_2;

import java.util.stream.IntStream;

public enum TrafficLight {

    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private final String nextLight;

    TrafficLight(String nextLight) {
        this.nextLight = nextLight;
    }

    public String getNextLight() {
        return this.nextLight;
    }

    public static TrafficLight[] parseToArray(String... lightValues) {

        // Масив от получените String стойности
        TrafficLight[] trafficLight = new TrafficLight[(lightValues.length)];

        IntStream.range(0, lightValues.length).forEach(n ->
                trafficLight[n] = TrafficLight.valueOf(lightValues[n]));

        return trafficLight;
    }

    public static void changeToNextLight(TrafficLight... trafficLight) {

        // Променя на следващата светлина
        IntStream.range(0, trafficLight.length).forEach(n ->
                trafficLight[n] = TrafficLight.valueOf(trafficLight[n].nextLight));

    }

}
