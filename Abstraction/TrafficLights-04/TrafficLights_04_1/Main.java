package TrafficLights_04_1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lightValues = scanner.nextLine().split("\\s+");

        int rotations = Integer.parseInt(scanner.nextLine());

        TrafficLight.inputStoredLightValues(lightValues); // <- Съхранява прочетените стойности

        IntStream.range(0, rotations).forEach(rotation -> {

            // Сменя всички съхранени стойности на светофара и принтира резултата
            TrafficLight.changeAllLightValuesToNext();
            TrafficLight.printStoredLights();

        });

    }

}
