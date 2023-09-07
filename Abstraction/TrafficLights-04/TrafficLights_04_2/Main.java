package TrafficLights_04_2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Парсва прочетените входни данни
        TrafficLight[] trafficLight = TrafficLight.parseToArray(scanner.nextLine().split("\\s+"));

        int rotations = Integer.parseInt(scanner.nextLine());

        while (rotations-- > 0) {

            TrafficLight.changeToNextLight(trafficLight); // <- Променя всяка стойност на следващата

            String output = Arrays.stream(trafficLight).map(String::valueOf).
                    collect(Collectors.joining(" "));

            System.out.println(output);

        }

    }

}
